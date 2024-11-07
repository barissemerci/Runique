package com.barissemerci.runique

import android.app.Application
import com.barissemerci.auth.data.di.authDataModule
import com.barissemerci.auth.presentation.di.authViewModelModule
import com.barissemerci.core.data.di.coreDataModule
import com.barissemerci.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule

            )

        }
    }
}