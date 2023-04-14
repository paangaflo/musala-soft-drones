package com.musalasoft.drones.core.mapper;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.ports.output.dao.jpa.entity.Drone;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {MedicationItemMapper.class})
public interface DroneMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medications", source = "listMedicationItem")
    Drone dtoToEntity(DroneDTO droneDTO);

    @Mapping(source="id", target = "droneId")
    @Mapping(source="medications", target = "listMedicationItem")
    DroneDTO entityToDto(Drone drone);

    List<DroneDTO> toListDroneDto(List<Drone> listDrone);
}
