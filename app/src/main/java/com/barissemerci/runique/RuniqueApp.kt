package com.barissemerci.runique

import android.app.Application
import android.content.Context
import com.barissemerci.auth.data.di.authDataModule
import com.barissemerci.auth.presentation.di.authViewModelModule
import com.barissemerci.core.data.di.coreDataModule
import com.barissemerci.core.database.di.databaseModule
import com.barissemerci.run.data.di.runDataModule
import com.barissemerci.run.location.di.locationModule
import com.barissemerci.run.network.di.networkModule
import com.barissemerci.run.presentation.di.runPresentationModule
import com.barissemerci.runique.di.appModule
import com.google.android.play.core.splitcompat.SplitCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule

            )

        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}