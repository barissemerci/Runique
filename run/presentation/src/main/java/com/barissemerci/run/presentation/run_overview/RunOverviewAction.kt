package com.barissemerci.run.presentation.run_overview

import com.barissemerci.run.presentation.run_overview.model.RunUi

sealed interface RunOverviewAction {
    data object OnStartClick : RunOverviewAction
    data object OnLogoutClick : RunOverviewAction
    data object OnAnalyticsClick : RunOverviewAction
    data class OnDeleteRun(val runUi: RunUi) : RunOverviewAction
}