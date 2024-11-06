package com.barissemerci.core.data.di

import com.barissemerci.core.data.auth.EncryptedSessionStorage
import com.barissemerci.core.data.networking.HttpClientFactory
import com.barissemerci.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

}
