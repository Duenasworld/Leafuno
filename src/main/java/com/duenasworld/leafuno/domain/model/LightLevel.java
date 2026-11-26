package com.duenasworld.leafuno.domain.model;

/**
 * Describes a light category used for plant requirements and location conditions.
 */
public enum LightLevel {
    /** A location with very little direct or indirect daylight. */
    SHADE,

    /** A location with limited or filtered daylight. */
    PARTIAL_SHADE,

    /** A bright location with plenty of indirect daylight. */
    BRIGHT,

    /** A location that receives direct sunlight. */
    DIRECT_SUN
}
