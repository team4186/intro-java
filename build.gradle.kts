plugins {
  kotlin("jvm") version "2.0.21"
  id("org.jetbrains.compose") version "1.6.11"
  id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}

group = "frc4186"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

dependencies {
  implementation(compose.desktop.currentOs)
  testImplementation(kotlin("test"))
  testImplementation("io.mockk:mockk:1.13.13")
}

compose.desktop {
  application {
    mainClass = "ui.Maze"
  }
}

tasks {
  getByName<Test>("test") {
    useJUnitPlatform()
    systemProperties("java.util.logging.config.file" to "${project.layout.buildDirectory}/resources/test/logging-test.properties")
    testLogging {
      showStandardStreams = true
    }
  }

  getByName<Jar>("jar") {
    from(sourceSets.main.get().output)

    duplicatesStrategy = DuplicatesStrategy.WARN

    dependsOn(configurations.runtimeClasspath)
    from({
      configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
  }
}