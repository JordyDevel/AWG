package com.quasar.engine.libawg

class AWGCalibrator(
    var selectedMetal: Metal,
    var maxTemperature: Float,
    var selectedLenght: Float,
    var operationVoltage: Float,
    var operationPower: Float
) {
    companion object {

        /*
        r = r0 [1 + a(T - T0)] ; a = 0.0068
        R = r * L / A
        A = r * L / R
        P = VI
        P = I2 * R
        P = V2 / R
        */
    }

    private fun resistivity(): Float {
        return selectedMetal.resistivity * selectedMetal.temperatureCoefficient * (1 + (maxTemperature - 25f))
    }

    private fun resistance(transversalArea: Float): Float {
        return resistivity() * selectedLenght / transversalArea
    }

    private fun maxCurrentOnLine(transversalArea: Float): Float {
        val wirePower = operationVoltage * resistance(transversalArea)
        val totalLoad = operationPower + wirePower
        return totalLoad / operationVoltage
    }

    fun compute(): AWGCalibres? {
        val firstApproach = AWGCalibres
            .entries
            .filter { it.maxCurrent > operationPower / operationVoltage }
            .maxByOrNull { it.ordinal }
            ?.transversalArea ?: 0f

        return AWGCalibres
            .entries
            .filter { it.maxCurrent > maxCurrentOnLine(firstApproach) }
            .maxByOrNull { it.ordinal }
    }
}