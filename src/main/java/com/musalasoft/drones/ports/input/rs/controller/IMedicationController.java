package com.musalasoft.drones.ports.input.rs.controller;

import com.musalasoft.drones.ports.input.rs.controller.request.MedicationRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.MedicationResponse;
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

@RequestMapping("/medications")
@Tag(name = "Drone Operations", description = "Maintenance for medications.")
public interface IMedicationController {

    /**
     * Represents the endpoint to create a medication
     *
     * @param medicationRequest {@link MedicationRequest} data to be processed to build a medication
     * @return medicationResponse {@link MedicationResponse}
     */
    @PostMapping()
    @Operation(summary = "Performs the creation of a new medication")
    ResponseEntity<MedicationResponse> createMedication(@Valid @RequestBody MedicationRequest medicationRequest);

    /**
     * Represents the endpoint to get a medication for id
     *
     * @param medicationId {@link Integer} id unique of medication
     * @return medicationResponse {@link MedicationResponse}
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get information of the medication with specific id")
    ResponseEntity<MedicationResponse> getMedication(@PathVariable("id") Integer medicationId);

    /**
     * Represents the endpoint to get all medications
     *
     * @return list<MedicationResponse> {@link List<MedicationResponse>}
     */
    @GetMapping()
    @Operation(summary = "Get all the medications with information")
    ResponseEntity<List<MedicationResponse>> getAll();

    /**
     * Represents the endpoint to delete a medication for id
     *
     * @param medicationId {@link Integer} id unique of medication
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a medication with with specific id")
    ResponseEntity delete(@PathVariable("id") Integer medicationId);
}
