package com.musalasoft.drones.ports.input.rs.controller.impl;

import com.musalasoft.drones.core.service.IDispatchService;
import com.musalasoft.drones.ports.input.rs.controller.IDispatchController;
import com.musalasoft.drones.ports.input.rs.controller.mapper.IDispatchMapper;
import com.musalasoft.drones.ports.input.rs.controller.request.LoadRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.LoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DispatchControllerImpl implements IDispatchController {

    private final IDispatchService dispatchService;

    private final IDispatchMapper dispatchMapper;

    @Override public ResponseEntity<LoadResponse> loadDrone(LoadRequest loadRequest, Integer droneId) {
        return new ResponseEntity<>(
            dispatchMapper.toLoadResponse(dispatchService.load(droneId, loadRequest.getMedicationIds())),
            HttpStatus.OK
        );
    }
}

