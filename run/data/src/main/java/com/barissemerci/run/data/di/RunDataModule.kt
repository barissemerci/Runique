package com.barissemerci.run.data.di

import com.barissemerci.run.data.CreateRunWorker
import com.barissemerci.run.data.DeleteRunWorker
import com.barissemerci.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
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
}