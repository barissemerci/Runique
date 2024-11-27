package com.barissemerci.run.data.di

import com.barissemerci.core.domain.run.SyncRunScheduler
import com.barissemerci.run.data.CreateRunWorker
import com.barissemerci.run.data.DeleteRunWorker
import com.barissemerci.run.data.FetchRunsWorker
import com.barissemerci.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(
        ::CreateRunWorker
    )
    workerOf(
        ::DeleteRunWorker
    )
    workerOf(
        ::FetchRunsWorker
    )

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}