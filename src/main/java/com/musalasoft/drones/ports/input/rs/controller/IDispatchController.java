package com.musalasoft.drones.ports.input.rs.controller;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.ports.input.rs.controller.request.DroneRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dispatch")
@Tag(name = "Drone Operations", description = "Maintenance for drones.")
public interface IDispatchController {

    /**
     * Represents the endpoint to create a drone
     *
     * @param droneRequest {@link DroneRequest} data to be processed to build the drone
     * @return droneResponse {@link DroneResponse}
     */

    @PostMapping("/drone")
    @Operation(summary = "Performs the creation of a new drone")
    ResponseEntity<DroneResponse> createDrone(@Valid @RequestBody DroneRequest droneRequest);

    @GetMapping("/drone/{id}")
    ResponseEntity<DroneDTO> getDrone(@PathVariable("id") Integer droneId);
}
