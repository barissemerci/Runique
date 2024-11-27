package com.barissemerci.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick : AnalyticsAction
}