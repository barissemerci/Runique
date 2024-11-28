package com.barissemerci.analytics.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.barissemerci.analytics.data.di.analyticsDataModule
import com.barissemerci.analytics.presentation.AnalyticsDashboardScreenRoot
import com.barissemerci.analytics.presentation.di.analyticsPresentationModule
import com.barissemerci.core.presentation.designsystem.RuniqueTheme
import com.google.android.play.core.splitcompat.SplitCompat
import org.koin.core.context.loadKoinModules

class AnalyticsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(listOf(analyticsPresentationModule, analyticsDataModule))
        SplitCompat.install(this)

        setContent {
            RuniqueTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "analytics_dashboard") {
                    composable(
                        route = "analytics_dashboard"
                    ) {
                        AnalyticsDashboardScreenRoot(
                            onBackClick = { finish() }
                        )
                    }

                }
            }
        }

    }

}