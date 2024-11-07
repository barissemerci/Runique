package com.barissemerci.auth.presentation.di

import com.barissemerci.auth.presentation.login.LoginViewModel
import com.barissemerci.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(
        ::RegisterViewModel
    )
    viewModelOf(
        ::LoginViewModel
    )
}