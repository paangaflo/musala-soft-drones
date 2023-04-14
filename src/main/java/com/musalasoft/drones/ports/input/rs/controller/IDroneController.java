package com.musalasoft.drones.ports.input.rs.controller;

import com.musalasoft.drones.ports.input.rs.controller.request.DroneRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/drones")
@Tag(name = "Drone Operations", description = "Maintenance for drones.")
public interface IDroneController {

    /**
     * Represents the endpoint to create a drone
     *
     * @param droneRequest {@link DroneRequest} data to be processed to build the drone
     * @return droneResponse {@link DroneResponse}
     */
    @PostMapping()
    @Operation(summary = "Performs the creation of a new drone")
    ResponseEntity<DroneResponse> createDrone(@Valid @RequestBody DroneRequest droneRequest);

    /**
     * Represents the endpoint to get a drone for id
     *
     * @param droneId {@link Integer} id unique of drone
     * @return droneResponse {@link DroneResponse}
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get information of the drone with specific id")
    ResponseEntity<DroneResponse> getDrone(@PathVariable("id") Integer droneId);

    /**
     * Represents the endpoint to get all drones
     *
     * @return list<DroneResponse> {@link List<DroneResponse>}
     */
    @GetMapping()
    @Operation(summary = "Get all the drones with information")
    ResponseEntity<List<DroneResponse>> getAll();

    /**
     * Represents the endpoint to delete a drone for id
     *
     * @param droneId {@link Integer} id unique of drone
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a drone with with specific id")
    ResponseEntity delete(@PathVariable("id") Integer droneId);
}
