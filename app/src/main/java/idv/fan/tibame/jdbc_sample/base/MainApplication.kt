package idv.fan.tibame.jdbc_sample.base

import android.app.Application
import idv.fan.tibame.jdbc_sample.BuildConfig
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimberLog()
    }

    private fun initTimberLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}