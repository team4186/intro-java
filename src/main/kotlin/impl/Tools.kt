@file:Suppress("FunctionName")

package impl


inline fun <reified T> ToDo(message: String = "Not Implemented"): T {
    TODO(message)
}

