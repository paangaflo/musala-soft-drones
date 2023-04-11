package com.musalasoft.drones.ports.input.rs.controller.impl;

import com.musalasoft.drones.commons.exception.ConflictException;
import com.musalasoft.drones.config.property.GeneralProperties;
import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.service.IDroneService;
import com.musalasoft.drones.ports.input.rs.controller.IDispatchController;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IDroneMapper;
import com.musalasoft.drones.ports.input.rs.controller.request.DroneRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DispatchControllerImpl implements IDispatchController {

    private final IDroneService droneService;

    private final IDroneMapper droneMapper;

    private final GeneralProperties generalProperties;

    @Override
    public ResponseEntity<DroneResponse> createDrone(@RequestBody DroneRequest droneRequest) {
        if(droneService.getAll().size() >= Integer.parseInt(generalProperties.getLimitDrones())) {
           throw new ConflictException("I exceed the limit of drones to create");
        }
        DroneDTO droneDTO = droneMapper.droneRequestToDroneDTO(droneRequest);
        return new ResponseEntity<>(
            droneMapper.toDroneResponse(droneService.createDrone(droneDTO)),
            HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<DroneDTO> getDrone(Integer droneId) {
        return droneService.getDrone(droneId)
            .map(drone -> new ResponseEntity<>(drone, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

