package com.barissemerci.auth.presentation.register

import com.barissemerci.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent //for navigating to login screen
    data class Error(val error: UiText) : RegisterEvent


}