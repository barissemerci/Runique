package com.barissemerci.run.domain

import com.barissemerci.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observeLocation(interval : Long) : Flow<LocationWithAltitude>
}