package com.barissemerci.auth.data.di

import com.barissemerci.auth.data.AuthRepositoryImpl
import com.barissemerci.auth.data.EmailPatternValidator
import com.barissemerci.auth.domain.AuthRepository
import com.barissemerci.auth.domain.PatternValidator
import com.barissemerci.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator) //If UserDataValidator constructor parameters provided by koin, do it automatically
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>() // bind to its abstraction


}