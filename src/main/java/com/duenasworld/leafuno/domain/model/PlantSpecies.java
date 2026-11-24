package com.duenasworld.leafuno.domain.model;

/**
 * This class is the sceleton for the plant-species-seed.json file
 */
public class PlantSpecies {
    private String id;
    private String name;
    private String botanicalName;
    private String family;
    private LightLevel lightRequirement;
    private TemperatureLevel temperatureRequirement;
    private String humidityRequirement;
    private Integer baseIntervalDays;
    private String idealLocationDetail;
    private String preferredTemperatureRange;
    private String wateringIntervalPractice;
    private String wateringCheckAlternative;
    private String description;
    private String careNote;
    private String sources;

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
