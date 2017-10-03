package org.nsdev.mypeeps.presentation.base

open class ThreadQueue(private val threadRunner: ThreadRunner) {

    var enabled: Boolean = false
        set(enabled) {
            field = enabled

            if (!this.enabled) {
                clear()
            }
        }

    interface ThreadRunner {
        fun run(runnable: Runnable)

        fun runDelayed(runnable: Runnable, delayMilliseconds: Long)

        fun clear()
    }

    open fun run(runnable: Runnable) {
        if (enabled) {
            threadRunner.run(runnable)
        }
    }

    open fun runDelayed(runnable: Runnable, delayMilliseconds: Long) {
        if (enabled) {
            threadRunner.runDelayed(runnable, delayMilliseconds)
        }
    }

    open fun clear() {
        threadRunner.clear()
    }
}
