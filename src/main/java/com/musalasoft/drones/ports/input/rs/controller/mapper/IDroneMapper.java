package com.musalasoft.drones.ports.input.rs.controller.mapper;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.ports.input.rs.controller.request.DroneRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.DroneResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IDroneMapper {

    @Mapping(target = "droneId", ignore = true)
    @Mapping(target = "batteryCapacity", ignore = true)
    @Mapping(target = "state", ignore = true)
    DroneDTO droneRequestToDroneDTO(DroneRequest droneRequest);

    DroneResponse toDroneResponse(DroneDTO droneDTO);
}
