package com.musalasoft.drones.ports.input.rs.controller;

import com.musalasoft.drones.ports.input.rs.controller.request.LoadRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import com.musalasoft.drones.ports.input.rs.controller.response.LoadResponse;
import com.musalasoft.drones.ports.input.rs.controller.response.MedicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dispatch")
@Tag(name = "Dispatch that allows to comunicate with the drones", description = "Dispatch for drones.")
public interface IDispatchController {

    /**
     * Represents the endpoint to load a drone with medications
     *
     * @param loadRequest {@link LoadRequest} data to be processed to load the drone with medications
     * @return dispatchResponse {@link LoadResponse}
     */
    @PostMapping("/drone/{id}")
    @Operation(summary = "Allows loading a drone with the medication specified as ids")
    ResponseEntity<LoadResponse> loadDrone(
        @Valid @RequestBody LoadRequest loadRequest,
        @PathVariable("id") Integer droneId
    );

    @GetMapping("/drone/{id}/medication")
    @Operation(summary = "Get information of the medications associated to a drone with the specified id")
    ResponseEntity<List<MedicationResponse>> checkMedication(@PathVariable("id") Integer droneId);

    @GetMapping("/drone/available")
    @Operation(summary = "Get information of the drones available for loading")
    ResponseEntity<List<DroneResponse>> availableDrone();

    @GetMapping("/drone/{id}/battery")
    @Operation(summary = "Get information of battery level of the drone")
    ResponseEntity<Integer> batteryLevelDrone(@PathVariable("id") Integer droneId);
}
