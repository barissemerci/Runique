package com.barissemerci.run.presentation.active_run

import com.barissemerci.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
     data class Error(val error : UiText) : ActiveRunEvent
    data object RunSaved : ActiveRunEvent
}