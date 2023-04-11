package com.musalasoft.drones.core.mapper;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.ports.output.dao.jpa.entity.Drone;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface DroneMapper {

    @Mapping(target = "id", ignore = true)
    Drone dtoToEntity(DroneDTO droneDTO);

    @Mapping(source="id", target = "droneId")
    DroneDTO entityToDto(Drone drone);

    List<DroneDTO> listEntityToListDto(List<Drone> listDrone);
}
