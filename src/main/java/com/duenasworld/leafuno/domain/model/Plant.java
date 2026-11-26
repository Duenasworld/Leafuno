package com.duenasworld.leafuno.domain.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents an individual plant owned by the user.
 * It refers to its species and location by their identifiers.
 */
public class Plant {

    private String id;                  // Stable identifier for this individual plant.
    private String personalName;        // Name chosen by the user for this plant.
    private String plantSpeciesId;      // Identifier of the plant species in the species catalogue.
    private String locationId;          // Identifier of the location where this plant is placed.
    private LocalDate lastWateredDate;  // Date when this plant was last watered
    private String ownNotes;            // Optional notes entered by the user.

    /**
     * Creates an empty plant for restoring stored data.
     */
    public Plant() {
    }

    /**
     * Creates a new plant and assigns a unique identifier.
     *
     * @param personalName the name chosen by the user
     * @param plantSpeciesId the identifier of the plant species
     * @param locationId the identifier of the location
     * @param ownNotes optional notes entered by the user
     * @return the newly created plant
     */
    public static Plant createNew(
            String personalName,
            String plantSpeciesId,
            String locationId,
            LocalDate lastWateredDate,
            String ownNotes
    ) {
        Plant plant = new Plant();
        plant.id = UUID.randomUUID().toString();
        plant.personalName = personalName;
        plant.plantSpeciesId = plantSpeciesId;
        plant.locationId = locationId;
        plant.lastWateredDate = lastWateredDate != null ? lastWateredDate : LocalDate.now();
        plant.ownNotes = ownNotes;
        return plant;
    }

    public String getId() {
        return id;
    }

    /**
     * Restores the identifier from stored data.
     * New plants should be created with {@link #createNew(String, String, String, LocalDate, String)}.
     *
     * @param id the identifier read from stored data
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPlantSpeciesId() {
        return plantSpeciesId;
    }

    public void setPlantSpeciesId(String plantSpeciesId) {
        this.plantSpeciesId = plantSpeciesId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public LocalDate getLastWateredDate() {
        return lastWateredDate;
    }

    public void setLastWateredDate(LocalDate lastWateredDate) {
        this.lastWateredDate = lastWateredDate;
    }

    public String getOwnNotes() {
        return ownNotes;
    }

    public void setOwnNotes(String ownNotes) {
        this.ownNotes = ownNotes;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id='" + id + '\'' +
                ", personalName='" + personalName + '\'' +
                ", plantSpeciesId='" + plantSpeciesId + '\'' +
                ", locationId='" + locationId + '\'' +
                ", lastWateredDate= '" + lastWateredDate + '\'' +
                ", ownNotes='" + ownNotes + '\'' +
                '}';
    }
}
