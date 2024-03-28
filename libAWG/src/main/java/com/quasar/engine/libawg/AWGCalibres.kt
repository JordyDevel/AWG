package com.quasar.engine.libawg

import kotlin.math.pow

enum class AWGCalibres {
    awg_0000,
    awg_000,
    awg_00,
    awg_0,
    awg_01,
    awg_02,
    awg_03,
    awg_04,
    awg_05,
    awg_06,
    awg_07,
    awg_08,
    awg_09,
    awg_10,
    awg_11,
    awg_12,
    awg_13,
    awg_14,
    awg_15,
    awg_16,
    awg_17,
    awg_18,
    awg_19,
    awg_20,
    awg_21,
    awg_22,
    awg_23,
    awg_24,
    awg_25,
    awg_26,
    awg_27,
    awg_28,
    awg_29,
    awg_30,
    awg_31,
    awg_32,
    awg_33,
    awg_34,
    awg_35,
    awg_36,
    awg_37,
    awg_38,
    awg_39,
    awg_40,
    awg_250,
    awg_350,
    awg_400,
    awg_500,
    awg_600,
    awg_750,
    awg_900,
    awg_1000;

    val maxCurrent: Float
        get() = when (this) {
            awg_0000 -> 302f
            awg_000 -> 239f
            awg_00 -> 190f
            awg_0 -> 150f
            awg_01 -> 119f
            awg_02 -> 94f
            awg_03 -> 75f
            awg_04 -> 60f
            awg_05 -> 47f
            awg_06 -> 37f
            awg_07 -> 30f
            awg_08 -> 24f
            awg_09 -> 19f
            awg_10 -> 15f
            awg_11 -> 12f
            awg_12 -> 9.3f
            awg_13 -> 7.4f
            awg_14 -> 5.9f
            awg_15 -> 4.7f
            awg_16 -> 3.7f
            awg_17 -> 2.9f
            awg_18 -> 2.3f
            awg_19 -> 1.8f
            awg_20 -> 1.5f
            awg_21 -> 1.2f
            awg_22 -> 0.92f
            awg_23 -> 0.729f
            awg_24 -> 0.577f
            awg_25 -> 0.457f
            awg_26 -> 0.361f
            awg_27 -> 0.288f
            awg_28 -> 0.226f
            awg_29 -> 0.182f
            awg_30 -> 0.142f
            awg_31 -> 0.113f
            awg_32 -> 0.091f
            awg_33 -> 0.072f
            awg_34 -> 0.056f
            awg_35 -> 0.044f
            awg_36 -> 0.035f
            awg_37 -> 0.0289f
            awg_38 -> 0.0228f
            awg_39 -> 0.0175f
            awg_40 -> 0.0137f
            awg_250 -> 0f
            awg_350 -> 0f
            awg_400 -> 0f
            awg_500 -> 0f
            awg_600 -> 0f
            awg_750 -> 0f
            awg_900 -> 0f
            awg_1000 -> 0f
        }

    val transversalArea: Float
        get() = 10f.pow(-6) * when (this) {
            awg_0000 -> 107f
            awg_000 -> 84.9f
            awg_00 -> 67.4f
            awg_0 -> 53.5f
            awg_01 -> 42.4f
            awg_02 -> 33.6f
            awg_03 -> 26.7f
            awg_04 -> 21.1f
            awg_05 -> 21.1f
            awg_06 -> 13.3f
            awg_07 -> 10.6f
            awg_08 -> 8.37f
            awg_09 -> 6.63f
            awg_10 -> 5.26f
            awg_11 -> 4.17f
            awg_12 -> 3.31f
            awg_13 -> 2.63f
            awg_14 -> 2.08f
            awg_15 -> 1.65f
            awg_16 -> 1.31f
            awg_17 -> 1.04f
            awg_18 -> 0.823f
            awg_19 -> 0.653f
            awg_20 -> 0.519f
            awg_21 -> 0.412f
            awg_22 -> 0.327f
            awg_23 -> 0.259f
            awg_24 -> 0.205f
            awg_25 -> 0.162f
            awg_26 -> 0.128f
            awg_27 -> 0.102f
            awg_28 -> 0.080f
            awg_29 -> 0.0647f
            awg_30 -> 0.0507f
            awg_31 -> 0.0401f
            awg_32 -> 0.0324f
            awg_33 -> 0.0255f
            awg_34 -> 0.0201f
            awg_35 -> 0.0159f
            awg_36 -> 0.0127f
            awg_37 -> 0.0103f
            awg_38 -> 0.00811f
            awg_39 -> 0.00621f
            awg_40 -> 0.00487f
            awg_250 -> 0.001f
            awg_350 -> 0.001f
            awg_400 -> 0.001f
            awg_500 -> 0.001f
            awg_600 -> 0.001f
            awg_750 -> 0.001f
            awg_900 -> 0.001f
            awg_1000 -> 0.001f
        }
}