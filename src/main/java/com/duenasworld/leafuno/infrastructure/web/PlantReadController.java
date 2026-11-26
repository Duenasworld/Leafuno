package com.duenasworld.leafuno.infrastructure.web;

import com.duenasworld.leafuno.application.InventoryService;
import com.duenasworld.leafuno.application.dto.LocationCreateInput;
import com.duenasworld.leafuno.application.dto.PlantCreateInput;
import com.duenasworld.leafuno.domain.model.AssessmentResult;
import com.duenasworld.leafuno.domain.model.Location;
import com.duenasworld.leafuno.domain.model.Plant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Temporary HTTP endpoints for checking shared inventory operations.
 */
@RestController
public class PlantReadController {

    private final InventoryService inventoryService;

    public PlantReadController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/")
    public String status() {
        return "Leafuno-Server läuft!";
    }

    @GetMapping("/location")
    public List<Location> getLocations() {
        return inventoryService.getAllLocations();
    }

    @PostMapping("/location")
    public Location addLocation(@RequestBody LocationCreateInput input) {
        return inventoryService.createLocation(input);
    }

    @GetMapping("/plant")
    public List<Plant> getPlants() {
        return inventoryService.getAllPlants();
    }

    @PostMapping("/plant")
    public Plant addPlant(@RequestBody PlantCreateInput input) {
        return inventoryService.createPlant(input);
    }

    @GetMapping("/plant/{id}/temperature-requirement")
    public String getTemperatureRequirement(@PathVariable String id) {
        return inventoryService.getTemperatureRequirementForPlant(id).name();
    }

    @GetMapping("/plant/{id}/assess-temperature-requirement")
    public AssessmentResult getTemperatureAssessment(@PathVariable String id) {
        return inventoryService.getTemperatureAssessmentForPlant(id);
    }
}
