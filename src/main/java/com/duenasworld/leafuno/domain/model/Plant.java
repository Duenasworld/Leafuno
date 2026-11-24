package com.duenasworld.leafuno.domain.model;

public class Plant {
    private String personalName;
    private String plantSpeciesId;
    private LightLevel lightRequirement;
    private TemperatureLevel temperatureRequirement;
    private String place;
    private String ownNotes;

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
                "personalName='" + personalName + '\'' +
                ", plantSpeciesId='" + plantSpeciesId + '\'' +
                ", lightRequirement=" + lightRequirement +
                ", temperatureRequirement=" + temperatureRequirement +
                ", place='" + place + '\'' +
                ", ownNotes='" + ownNotes + '\'' +
                '}';
    }
}
