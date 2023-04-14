package com.musalasoft.drones.core.mapper;

import com.musalasoft.drones.core.dto.MedicationItemDTO;
import com.musalasoft.drones.ports.output.dao.jpa.entity.DroneMedication;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {MedicationMapper.class})
public interface MedicationItemMapper {

    @Mappings({
        @Mapping(source = "id.idMedication", target = "medicationId"),
    })
    MedicationItemDTO toMedicationItemDTO(DroneMedication medication);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "drone", ignore = true),
        @Mapping(target = "medication", ignore = true),
        @Mapping(target = "id.idDrone", ignore = true)
    })
    DroneMedication toDroneMedication(MedicationItemDTO medicationItem);

    List<DroneMedication> toListDroneMedication(List<MedicationItemDTO> listMedicationItem);
}
