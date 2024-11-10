@file:OptIn(ExperimentalMaterial3Api::class)

package com.barissemerci.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.barissemerci.core.presentation.designsystem.AnalyticsIcon
import com.barissemerci.core.presentation.designsystem.LogoIcon
import com.barissemerci.core.presentation.designsystem.LogoutIcon
import com.barissemerci.core.presentation.designsystem.RunIcon
import com.barissemerci.core.presentation.designsystem.RuniqueTheme
import com.barissemerci.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.barissemerci.core.presentation.designsystem.components.RuniqueScaffold
import com.barissemerci.core.presentation.designsystem.components.RuniqueToolBar
import com.barissemerci.core.presentation.designsystem.components.util.DropDownItem
import com.barissemerci.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable

fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel()
) {
    RunOverviewScreen(
        onAction = { action ->
            when (action) {
                RunOverviewAction.OnStartClick -> onStartRunClick()
                else -> Unit
            }
            viewModel.onAction(action)

        }
    )
}

@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RuniqueScaffold(topAppBar = {
        RuniqueToolBar(
            showBackButton = false,
            title = stringResource(R.string.runique),
            scrollBehavior = scrollBehavior,
            onMenuItemClick = { index ->
                when (index) {
                    0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                    1 -> onAction(RunOverviewAction.OnLogoutClick)
                }

            },
            menuItems = listOf(
                DropDownItem(
                    icon = AnalyticsIcon,
                    title = stringResource(R.string.analytics),
                ), DropDownItem(
                    icon = LogoutIcon,
                    title = stringResource(R.string.logout),
                )
            ),
            startContent = {
                Icon(
                    imageVector = LogoIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            },

            )
    }, floatingActionButton = {
        RuniqueFloatingActionButton(
            icon = RunIcon,
            onClick = {
                onAction(RunOverviewAction.OnStartClick)
            })
    }) { padding ->

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RuniqueTheme {
        RunOverviewScreen(onAction = {})
    }
}