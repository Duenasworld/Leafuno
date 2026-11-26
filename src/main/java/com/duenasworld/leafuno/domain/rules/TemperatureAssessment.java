package com.duenasworld.leafuno.domain.rules;

import com.duenasworld.leafuno.domain.model.AssessmentResult;
import com.duenasworld.leafuno.domain.model.Suitability;
import com.duenasworld.leafuno.domain.model.TemperatureLevel;

/**
 * Compares a plant species temperature requirement with a location temperature level.
 */
public class TemperatureAssessment {

    /**
     * Assesses the difference between the required and actual temperature levels.
     *
     * @param temperatureRequirement the preferred temperature level of the species
     * @param locationTemperature the selected temperature level of the location
     * @return the assessment status with a human-readable explanation
     */
    public AssessmentResult assess(
            TemperatureLevel temperatureRequirement,
            TemperatureLevel locationTemperature
    ) {
        if (temperatureRequirement == null) {
            return new AssessmentResult(
                    Suitability.NOT_ASSESSED,
                    "Die Temperatur wird nicht bewertet, da für die Pflanzenart kein Temperaturbedarf hinterlegt ist."
            );
        }

        if (locationTemperature == null) {
            return new AssessmentResult(
                    Suitability.NOT_ASSESSED,
                    "Die Temperatur wird nicht bewertet, da für den Standort keine Temperaturstufe festgelegt ist."
            );
        }

        int requirementRank = rank(temperatureRequirement);
        int locationRank = rank(locationTemperature);
        int difference = Math.abs(requirementRank - locationRank);

        if (difference == 0) {
            return new AssessmentResult(
                    Suitability.SUITABLE,
                    "Die Standorttemperatur entspricht dem Temperaturbedarf der Pflanzenart."
            );
        }

        Suitability suitability = difference == 1
                ? Suitability.PARTIALLY_SUITABLE
                : Suitability.NOT_SUITABLE;

        String direction = locationRank > requirementRank ? "wärmer" : "kühler";
        String differenceText = difference == 1
                ? "eine Temperaturstufe"
                : "zwei oder mehr Temperaturstufen";
        String explanation = "Der Standort ist " + differenceText + " " + direction
                + " als der empfohlene Temperaturbedarf der Pflanzenart.";

        return new AssessmentResult(suitability, explanation);
    }

    private int rank(TemperatureLevel level) {
        return switch (level) {
            case COOL -> 0;
            case NORMAL -> 1;
            case WARM -> 2;
        };
    }
}
