package com.barissemerci.run.location

import android.location.Location
import com.barissemerci.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        com.barissemerci.core.domain.location.Location(
            latitude,
            longitude
        ), altitude
    )
}