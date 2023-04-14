package com.musalasoft.drones.ports.input.rs.controller.mapper;

import com.musalasoft.drones.core.dto.MedicationDTO;
import com.musalasoft.drones.ports.input.rs.controller.request.MedicationRequest;
import com.musalasoft.drones.ports.input.rs.controller.response.MedicationResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IMedicationMapper {

    @Mapping(target = "medicationId", ignore = true)
    MedicationDTO medicationRequestToMedicationDTO(MedicationRequest medicationRequest);

    MedicationResponse toMedicationResponse(MedicationDTO medicationDTO);

    List<MedicationResponse> toListMedicationResponse(List<MedicationDTO> listMedicationDTO);
}
