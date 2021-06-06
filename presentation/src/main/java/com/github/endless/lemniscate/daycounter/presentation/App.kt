package com.github.endless.lemniscate.daycounter.presentation

import android.app.Application
import com.github.endless.lemniscate.daycounter.presentation.di.ApplicationComponent
import com.github.endless.lemniscate.daycounter.presentation.di.ContextModule
import com.github.endless.lemniscate.daycounter.presentation.di.DaggerApplicationComponent

class App: Application() {
    companion object {
        lateinit var applicationComponent: ApplicationComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }


}