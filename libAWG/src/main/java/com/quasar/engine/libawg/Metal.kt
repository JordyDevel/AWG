package com.quasar.engine.libawg

import kotlin.math.pow

enum class Metal {
    GOLD, SILVER, CUPPER, ALUMINIUM;

    val resistivity: Float
        get() = when (this) {
            GOLD -> 1f
            SILVER -> 1f
            CUPPER -> 1.724.times(10.0.pow(-8.0)).toFloat()
            ALUMINIUM -> 1f
        }

    val temperatureCoefficient: Float
        get() = when (this) {
            GOLD -> 1f
            SILVER -> 2f
            CUPPER -> 0.0039f
            ALUMINIUM -> 1f
        }
}