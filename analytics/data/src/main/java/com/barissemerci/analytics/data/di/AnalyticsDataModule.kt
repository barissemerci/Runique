package com.barissemerci.analytics.data.di

import com.barissemerci.analytics.data.RoomAnalyticsRepository
import com.barissemerci.analytics.domain.AnalyticsRepository
import com.barissemerci.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsDataModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }

}