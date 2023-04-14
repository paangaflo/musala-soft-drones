package com.musalasoft.drones.ports.input.rs.controller.impl;

import com.musalasoft.drones.core.dto.MedicationDTO;
import com.musalasoft.drones.core.service.IMedicationService;
import com.musalasoft.drones.ports.input.rs.controller.IMedicationController;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IMedicationMapper;
import com.musalasoft.drones.ports.input.rs.controller.request.MedicationRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.MedicationResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MedicationControllerImpl implements IMedicationController {

    private final IMedicationService medicationService;

    private final IMedicationMapper medicationMapper;

    @Override
    public ResponseEntity<MedicationResponse> createMedication(MedicationRequest medicationRequest) {
        MedicationDTO medicationDTO = medicationMapper.medicationRequestToMedicationDTO(medicationRequest);
        return new ResponseEntity<>(
            medicationMapper.toMedicationResponse(medicationService.save(medicationDTO)),
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<MedicationResponse> getMedication(Integer medicationId) {
        return medicationService.get(medicationId)
            .map(medication -> new ResponseEntity<>(medicationMapper.toMedicationResponse(medication), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<MedicationResponse>> getAll() {
        return new ResponseEntity<>(medicationMapper.toListMedicationResponse(medicationService.getAll()),
            HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Integer medicationId) {
        if (medicationService.delete(medicationId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

