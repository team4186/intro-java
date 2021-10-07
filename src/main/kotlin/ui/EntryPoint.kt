package ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import impl.maze.Labyrinth
import impl.maze.Robot
import impl.maze.Runner
import impl.maze.Scenario
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import maze.Maze
import kotlin.math.floor

@JvmOverloads
fun main(
    args: List<Pair<String, () -> Scenario>> = listOf("simple" to Maze::Simple)
) = application {
  val windowState = rememberWindowState(width = 1000.dp, height = 800.dp)

  Window(
      onCloseRequest = ::exitApplication,
      title = "Robots!",
      state = windowState
  ) {
    var selected by remember { mutableStateOf(args.first()) }
    var runner by remember(selected) { mutableStateOf(Runner(selected.second())) }
    var robot by remember(runner) { mutableStateOf(runner.robot()) }
    var solved by remember(runner) { mutableStateOf(runner.isSolved) }
    var running by remember(runner, solved) { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    MaterialTheme {
      Row(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
        Canvas(modifier = Modifier.fillMaxHeight().weight(1F)) {
          val canvasWidth = size.width
          val canvasHeight = size.height

          val maxLineLength = runner.labyrinth.cells.maxOf { it.length }
          val cellSize = floor(minOf(canvasWidth / maxLineLength, canvasHeight / runner.labyrinth.cells.size))
          val xOffset = floor((canvasWidth - (cellSize * maxLineLength)) * 0.5F)
          val yOffset = floor((canvasHeight - (cellSize * runner.labyrinth.cells.size)) * 0.5F)

          drawMap(runner.labyrinth.cells, cellSize, xOffset, yOffset)
          drawRobot(robot, cellSize, xOffset, yOffset)
        }

        Column {
          LazyColumn(Modifier.weight(1F)) {
            items(args) { selection ->
              Button(
                  onClick = { selected = selection }
              ) {
                Text(selection.first)
              }
            }
          }

          Button(
              modifier = Modifier.align(Alignment.CenterHorizontally),
              onClick = {
                if (!solved && !running) {
                  robot = runner.step()
                  solved = runner.isSolved
                }
              }
          ) {
            Text(if (solved) "Finished" else "Step")
          }

          Button(
              modifier = Modifier.align(Alignment.CenterHorizontally),
              onClick = {
                if (!running) {
                  scope.launch {
                    running = true
                    while (!solved) {
                      robot = runner.step()
                      solved = runner.isSolved
                      delay(250)
                    }
                    running = false
                  }
                }
              }
          ) {
            Text(if (running) "Stop" else "Run")
          }

          Button(
              modifier = Modifier.align(Alignment.CenterHorizontally),
              onClick = { runner = Runner(selected.second()) }
          ) {
            Text("Reset")
          }
        }
      }
    }
  }
}

private fun DrawScope.drawMap(map: Array<String>, cellSize: Float, xOffset: Float, yOffset: Float) {
  for ((y, line) in map.withIndex()) {
    for ((x, cell) in line.withIndex()) {
      when (cell) {
        '#' -> drawRect(
            color = Color.Black,
            topLeft = Offset(x * cellSize + xOffset, cellSize * y + yOffset),
            size = Size(cellSize, cellSize)
        )
        'x' -> drawCircle(
            color = Color.Gray,
            center = Offset(x * cellSize + xOffset + cellSize * 0.5F, cellSize * y + yOffset + cellSize * 0.5F),
            radius = cellSize * 0.5F
        )
      }
    }
  }
}

private fun DrawScope.drawRobot(robot: Robot, cellSize: Float, xOffset: Float, yOffset: Float) {
  drawCircle(
      color = Color.Green,
      center = Offset(robot.x * cellSize + xOffset + cellSize * 0.5F, cellSize * robot.y + yOffset + cellSize * 0.5F),
      radius = cellSize * 0.5F
  )

  translate(left = robot.x * cellSize + xOffset, top = cellSize * robot.y + yOffset) {
    rotate((robot.rotation - Labyrinth.ORIENTATION_180) * 90F, Offset(cellSize * 0.5F, cellSize * 0.5F)) {
      drawPath(
          Path().apply {
            moveTo(cellSize * 0.5F, cellSize * (0.5F - 0.2F))
            lineTo(cellSize * 0.2F, cellSize * 0.5F)
            lineTo(cellSize * 0.5F, cellSize * (0.5F + 0.2F))
            moveTo(cellSize * 0.2F, cellSize * 0.5F)
            lineTo(cellSize * 0.8F, cellSize * 0.5F)
          },
          color = Color.Black,
          style = Stroke(
              width = 10.dp.toPx(),
              cap = StrokeCap.Round,
              join = StrokeJoin.Round
          )
      )
    }
  }
}
