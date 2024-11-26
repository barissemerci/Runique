package com.barissemerci.run.network.di

import com.barissemerci.core.domain.run.RemoteRunDataSource
import com.barissemerci.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}
