package com.barissemerci.run.presentation.active_run.maps

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import com.barissemerci.core.domain.location.LocationTimestamp
import kotlin.math.abs

object PolylineColorCalculator {

    fun locationsToColor(location1: LocationTimestamp, location2: LocationTimestamp): Color {
      val distanceMeters = location1.location.location.distanceTo(location2.location.location)
        val timeDiffSeconds = abs((location1.durationTimeStamp - location2.durationTimeStamp).inWholeSeconds)
        val speedKmh = distanceMeters / timeDiffSeconds * 3.6
        return interpolateColor(speedKmh, 5.0, 20.0, Color.Green, Color.Yellow, Color.Red)
    }

    private fun interpolateColor(
        speedKmh: Double,
        minSpeed: Double,
        maxSpeed: Double,
        colorStart: Color,
        colorMid: Color,
        colorEnd: Color,

        ): Color {
        val ratio = (speedKmh - minSpeed) / (maxSpeed - minSpeed).coerceIn(0.0..1.0)
        val colorInt = if (ratio <= 0.5) {
            val midRatio = ratio / 0.5
            ColorUtils.blendARGB(colorStart.toArgb(), colorMid.toArgb(), midRatio.toFloat())
        } else {
            val midToEndRatio = (ratio - 0.5) / 0.5
            ColorUtils.blendARGB(colorMid.toArgb(), colorEnd.toArgb(), midToEndRatio.toFloat())
        }
        return Color(colorInt)
    }
}