package com.duenasworld.leafuno.domain.model;

/**
 * Describes a broad temperature category used for plant requirements
 * and location conditions.
 */
public enum TemperatureLevel {
    /** A cool indoor location - currently < 18° Celsius. */
    COOL,

    /** A typical indoor temperature - currently between 18-22° Celsius. */
    NORMAL,

    /** A warm indoor location - currently > 22° Celsius. */
    WARM
}
