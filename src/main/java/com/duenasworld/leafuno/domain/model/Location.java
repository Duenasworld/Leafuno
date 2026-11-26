package com.duenasworld.leafuno.domain.model;

import java.util.UUID;

/**
 * Represents a specific place where one or more plants can be located.
 * The light and temperature levels describe the conditions at that place.
 */
public class Location {

    private String id;                          // Stable identifier used by plants to refer to this location.
    private String roomName;                    // Name of the room, for example "Living room".
    private String spotName;                    // Specific spot within the room, for example "Left windowsill".
    private LightLevel lightLevel;              // Actual light category at this location.
    private TemperatureLevel temperatureLevel;  // Actual temperature category at this location.

    /**
     * Creates an empty location for restoring stored data.
     */
    public Location() {
    }

    /**
     * Creates a new location and assigns a unique identifier.
     *
     * @param roomName the name of the room
     * @param spotName the specific spot within the room
     * @param lightLevel the actual light category at the spot
     * @param temperatureLevel the actual temperature category at the spot
     * @return the newly created location
     */
    public static Location createNew(
            String roomName,
            String spotName,
            LightLevel lightLevel,
            TemperatureLevel temperatureLevel
    ) {
        Location location = new Location();
        location.id = UUID.randomUUID().toString();
        location.roomName = roomName;
        location.spotName = spotName;
        location.lightLevel = lightLevel;
        location.temperatureLevel = temperatureLevel;
        return location;
    }

    public String getId() {
        return id;
    }

    /**
     * Restores the identifier from stored data.
     * New locations should be created with {@link #createNew(String, String, LightLevel, TemperatureLevel)}.
     *
     * @param id the identifier read from stored data
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public LightLevel getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(LightLevel lightLevel) {
        this.lightLevel = lightLevel;
    }

    public TemperatureLevel getTemperatureLevel() {
        return temperatureLevel;
    }

    public void setTemperatureLevel(TemperatureLevel temperatureLevel) {
        this.temperatureLevel = temperatureLevel;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", roomName='" + roomName + '\'' +
                ", spotName='" + spotName + '\'' +
                ", lightLevel=" + lightLevel +
                ", temperatureLevel=" + temperatureLevel +
                '}';
    }
}
