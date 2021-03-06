// LANGUAGE_VERSION: 1.3

import kotlin.internal.contracts.*

inline fun myRun(block: () -> Unit): Unit {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}

fun getBool(): Boolean = false

fun withLabeledReturn(y: Int) {
    val x = myRun outer@ {
        myRun { return@outer Unit }
        println(y)
    }

    println(y)
    println(x)
}