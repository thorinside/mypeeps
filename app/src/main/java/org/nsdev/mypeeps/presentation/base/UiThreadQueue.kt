package org.nsdev.mypeeps.presentation.base

import android.os.Handler
import android.os.Looper

open class UiThreadQueue : ThreadQueue(AndroidHandlerRunner(Handler(Looper.getMainLooper())))

