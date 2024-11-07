package com.barissemerci.auth.presentation.login

sealed interface LoginAction {
    data object OnLoginClick : LoginAction
    data object OnTogglePasswordVisibility : LoginAction
    data object OnRegisterClick : LoginAction
}