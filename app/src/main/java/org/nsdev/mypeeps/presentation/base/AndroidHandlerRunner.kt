package org.nsdev.mypeeps.presentation.base

import android.os.Handler
import android.os.Looper

class AndroidHandlerRunner(private val handler: Handler) : ThreadQueue.ThreadRunner {

    override fun run(runnable: Runnable) {
        if (handler.looper == Looper.myLooper()) {
            runnable.run() //run immediately if running from same thread
        } else {
            handler.post(runnable)
        }
    }

    override fun runDelayed(runnable: Runnable, delayMilliseconds: Long) {
        handler.postDelayed(runnable, delayMilliseconds)
    }

    override fun clear() {
        handler.removeCallbacksAndMessages(null)
    }
}
