package com.duenasworld.leafuno.domain.model;

import com.sun.javafx.image.impl.General;

/**
 * Represents a reusable profile for a plant species.
 * The profile contains general botanical information and care guidance.
 */
public class PlantSpecies {

    private String id;                          // Stable catalogue identifier, for example "monstera_deliciosa".
    private String name;                        // Common name shown to users.
    private String botanicalName;               // Scientific botanical name.
    private String family;                      // Botanical family of this species.
    private LightLevel lightRequirement;        // Preferred light category for this species.
    private TemperatureLevel temperatureRequirement; // Preferred temperature category for this species.
    private String humidityRequirement;         // General humidity guidance; not currently used in the core assessments.
    private Integer baseIntervalDays;           // Suggested baseline watering interval in days.
    private String idealLocationDetail;         // Descriptive guidance about a suitable location.
    private String preferredTemperatureRange;   // Human-readable preferred temperature range.
    private String wateringIntervalPractice;    // Reference information about common watering practice.
    private String wateringCheckAlternative;    // Alternative signs or checks that can indicate watering needs.
    private String description;                 // Short description of the species.
    private String careNote;                    // Additional care information or cautions.
    private String sources;                     //Sources used for the catalogue information.

    /**
     * Creates an empty species profile for loading catalogue data.
     */
    public PlantSpecies() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public LightLevel getLightRequirement() {
        return lightRequirement;
    }

    public void setLightRequirement(LightLevel lightRequirement) {
        this.lightRequirement = lightRequirement;
    }

    public TemperatureLevel getTemperatureRequirement() {
        return temperatureRequirement;
    }

    public void setTemperatureRequirement(TemperatureLevel temperatureRequirement) {
        this.temperatureRequirement = temperatureRequirement;
    }

    public String getHumidityRequirement() {
        return humidityRequirement;
    }

    public void setHumidityRequirement(String humidityRequirement) {
        this.humidityRequirement = humidityRequirement;
    }

    public Integer getBaseIntervalDays() {
        return baseIntervalDays;
    }

    public void setBaseIntervalDays(Integer baseIntervalDays) {
        this.baseIntervalDays = baseIntervalDays;
    }

    public String getIdealLocationDetail() {
        return idealLocationDetail;
    }

    public void setIdealLocationDetail(String idealLocationDetail) {
        this.idealLocationDetail = idealLocationDetail;
    }

    public String getPreferredTemperatureRange() {
        return preferredTemperatureRange;
    }

    public void setPreferredTemperatureRange(String preferredTemperatureRange) {
        this.preferredTemperatureRange = preferredTemperatureRange;
    }

    public String getWateringIntervalPractice() {
        return wateringIntervalPractice;
    }

    public void setWateringIntervalPractice(String wateringIntervalPractice) {
        this.wateringIntervalPractice = wateringIntervalPractice;
    }

    public String getWateringCheckAlternative() {
        return wateringCheckAlternative;
    }

    public void setWateringCheckAlternative(String wateringCheckAlternative) {
        this.wateringCheckAlternative = wateringCheckAlternative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCareNote() {
        return careNote;
    }

    public void setCareNote(String careNote) {
        this.careNote = careNote;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "PlantSpecies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", botanicalName='" + botanicalName + '\'' +
                ", family='" + family + '\'' +
                ", lightRequirement=" + lightRequirement +
                ", temperatureRequirement=" + temperatureRequirement +
                ", humidityRequirement='" + humidityRequirement + '\'' +
                ", baseIntervalDays=" + baseIntervalDays +
                ", idealLocationDetail='" + idealLocationDetail + '\'' +
                ", preferredTemperatureRange='" + preferredTemperatureRange + '\'' +
                ", wateringIntervalPractice='" + wateringIntervalPractice + '\'' +
                ", wateringCheckAlternative='" + wateringCheckAlternative + '\'' +
                ", description='" + description + '\'' +
                ", careNote='" + careNote + '\'' +
                ", sources='" + sources + '\'' +
                '}';
    }
}
