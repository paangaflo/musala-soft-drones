package com.musalasoft.drones.core.mapper;

import com.musalasoft.drones.core.dto.MedicationDTO;
import com.musalasoft.drones.ports.output.dao.jpa.entity.Medication;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface MedicationMapper {

    @InheritInverseConfiguration
    @Mapping(source="medicationId", target = "id")
    Medication dtoToEntity(MedicationDTO medicationDTO);

    @Mapping(source="id", target = "medicationId")
    MedicationDTO entityToDto(Medication medication);

    List<MedicationDTO> toListMedicationDto(List<Medication> medication);
}
