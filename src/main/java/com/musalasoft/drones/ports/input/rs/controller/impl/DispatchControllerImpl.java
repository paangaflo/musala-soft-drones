package com.musalasoft.drones.ports.input.rs.controller.impl;

import com.musalasoft.drones.core.service.IDispatchService;
import com.musalasoft.drones.ports.input.rs.controller.IDispatchController;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IDispatchMapper;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IDroneMapper;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IMedicationMapper;
import com.musalasoft.drones.ports.input.rs.controller.request.LoadRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import com.musalasoft.drones.ports.input.rs.controller.response.LoadResponse;
import com.musalasoft.drones.ports.input.rs.controller.response.MedicationResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DispatchControllerImpl implements IDispatchController {

    private final IDispatchService dispatchService;

    private final IDispatchMapper dispatchMapper;

    private final IMedicationMapper medicationMapper;

    private final IDroneMapper droneMapper;

    @Override public ResponseEntity<LoadResponse> loadDrone(LoadRequest loadRequest, Integer droneId) {
        return new ResponseEntity<>(
            dispatchMapper.toLoadResponse(dispatchService.loadDrone(droneId, loadRequest.getMedicationIds())),
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<List<MedicationResponse>> checkMedication(Integer droneId) {
        return new ResponseEntity<>(medicationMapper.toListMedicationResponse(
            dispatchService.checkMedication(droneId)),
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<List<DroneResponse>> availableDrone() {
        return new ResponseEntity<>(droneMapper.toListDroneResponse(
            dispatchService.availableDrone()),
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Integer> batteryLevelDrone(Integer droneId) {
        return new ResponseEntity<>(
            dispatchService.batteryLevelDrone(droneId),
            HttpStatus.OK
        );
    }
}

