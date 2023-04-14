package com.musalasoft.drones.ports.input.rs.controller.impl;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.service.IDroneService;
import com.musalasoft.drones.ports.input.rs.controller.IDroneController;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IDroneMapper;
import com.musalasoft.drones.ports.input.rs.controller.request.DroneRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DroneControllerImpl implements IDroneController {

    private final IDroneService droneService;

    private final IDroneMapper droneMapper;

    @Override
    public ResponseEntity<DroneResponse> createDrone(@RequestBody DroneRequest droneRequest) {
        DroneDTO droneDTO = droneMapper.droneRequestToDroneDTO(droneRequest);
        return new ResponseEntity<>(
            droneMapper.toDroneResponse(droneService.save(droneDTO)),
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<DroneResponse> getDrone(Integer droneId) {
        return droneService.get(droneId)
            .map(drone -> new ResponseEntity<>(droneMapper.toDroneResponse(drone), HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override public ResponseEntity<List<DroneResponse>> getAll() {
        return new ResponseEntity<>(droneMapper.toListDroneResponse(droneService.getAll()),
            HttpStatus.OK);
    }

    @Override public ResponseEntity delete(Integer droneId) {
        if (droneService.delete(droneId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

