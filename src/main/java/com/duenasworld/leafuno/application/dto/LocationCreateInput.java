package com.duenasworld.leafuno.application.dto;

import com.duenasworld.leafuno.domain.model.LightLevel;
import com.duenasworld.leafuno.domain.model.TemperatureLevel;

/**
 * Contains the values needed to create a location from an application request.
 */
public record LocationCreateInput(
        String roomName,
        String spotName,
        LightLevel lightLevel,
        TemperatureLevel temperatureLevel
) {
}
