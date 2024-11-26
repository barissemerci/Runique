package com.barissemerci.core.data.di

import com.barissemerci.core.data.auth.EncryptedSessionStorage
import com.barissemerci.core.data.networking.HttpClientFactory
import com.barissemerci.core.data.run.OfflineFirstRunRepository
import com.barissemerci.core.domain.SessionStorage
import com.barissemerci.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()

}
