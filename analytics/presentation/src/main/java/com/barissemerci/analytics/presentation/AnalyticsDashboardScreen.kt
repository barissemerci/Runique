@file:OptIn(ExperimentalMaterial3Api::class)

package com.barissemerci.analytics.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.barissemerci.analytics.presentation.components.AnalyticsCard
import com.barissemerci.core.presentation.designsystem.RuniqueTheme
import com.barissemerci.core.presentation.designsystem.components.RuniqueScaffold
import com.barissemerci.core.presentation.designsystem.components.RuniqueToolBar
import org.koin.androidx.compose.koinViewModel

@Composable

fun AnalyticsDashboardScreenRoot(
    onBackClick: () -> Unit,
    viewModel: AnalyticsDashboardViewModel = koinViewModel()

) {
    AnalyticsDashboardScreenRootScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AnalyticsAction.OnBackClick -> onBackClick()
            }
        }
    )
}

@Composable

private fun AnalyticsDashboardScreenRootScreen(
    state: AnalyticsDashboardState?,
    onAction: (AnalyticsAction) -> Unit
) {

    RuniqueScaffold(
        withGradient = true,
        topAppBar = {
            RuniqueToolBar(
                showBackButton = true,
                title = stringResource(R.string.analytics),
                onBackClick = { onAction(AnalyticsAction.OnBackClick) }
            )
        }

    ) { padding ->
        if (state == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    AnalyticsCard(
                        title = stringResource(R.string.total_distance_run),
                        value = state.totalDistanceRun,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        title = stringResource(R.string.total_time_run),
                        value = state.totalTimeRun,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    AnalyticsCard(
                        title = stringResource(R.string.fastest_ever_run),
                        value = state.fastestEverRun,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        title = stringResource(R.string.avg_distance),
                        value = state.avgDistance,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    AnalyticsCard(
                        title = stringResource(R.string.avg_pace),
                        value = state.fastestEverRun,
                        modifier = Modifier.weight(1f)
                    )

                }
            }
        }
    }
}

@Preview
@Composable
private fun AnalyticsDashboardScreenRootScreenPreview() {
    RuniqueTheme {
        AnalyticsDashboardScreenRootScreen(
            state = (AnalyticsDashboardState(
                totalDistanceRun = "10 km",
                totalTimeRun = "1h 30m",
                fastestEverRun = "5m 30s",
                avgDistance = "5 km",
                avgPace = "6m 30s"
            )),
            onAction = {}
        )
    }
}