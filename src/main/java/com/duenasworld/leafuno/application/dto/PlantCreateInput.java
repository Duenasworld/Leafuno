package com.duenasworld.leafuno.application.dto;

import java.time.LocalDate;

/**
 * Contains the values needed to create a plant from an application request.
 */
public record PlantCreateInput(
        String personalName,
        String plantSpeciesId,
        String locationId,
        LocalDate lastWateredDate,
        String ownNotes
) {
}
