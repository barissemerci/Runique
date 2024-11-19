package com.barissemerci.run.location.di

import com.barissemerci.run.domain.LocationObserver
import com.barissemerci.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}