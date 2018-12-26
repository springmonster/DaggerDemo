package demo.jetpack.com.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleOwner

class LifeCycleActivityPresenter : IPresenter {
    companion object {
        private const val TAG = "LifeCycleActivityPresenter"
    }

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        Log.d(TAG, "this is create")
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        Log.d(TAG, "this is destory")
    }

    override fun onChanged(lifecycleOwner: LifecycleOwner) {
        Log.d(TAG, "this is changed " + lifecycleOwner.lifecycle.currentState)
    }
}