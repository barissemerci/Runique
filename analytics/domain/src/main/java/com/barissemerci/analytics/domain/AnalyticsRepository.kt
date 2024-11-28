package com.barissemerci.analytics.domain

interface AnalyticsRepository {

    suspend fun getAnalyticsValues(): AnalyticsValues
}