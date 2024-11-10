package com.barissemerci.run.presentation.active_run

import com.barissemerci.core.domain.location.Location
import com.barissemerci.run.domain.RunData
import kotlin.time.Duration

data class ActiveRunState(
    val elapsedTime : Duration = Duration.ZERO,
    val runData: RunData = RunData(),
    val shouldTrack : Boolean = false,
    val hasStatedRunning : Boolean = false,
    val location : Location? = null,
    val isRunFinished : Boolean = false,
    val isRunSavingRun : Boolean = false

)
