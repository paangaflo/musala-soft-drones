package com.musalasoft.drones.core.service.impl;

import com.musalasoft.drones.commons.enums.State;
import com.musalasoft.drones.commons.exception.ConflictException;
import com.musalasoft.drones.commons.exception.NotFoundException;
import com.musalasoft.drones.config.property.GeneralProperties;
import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.dto.LoadDTO;
import com.musalasoft.drones.core.dto.MedicationDTO;
import com.musalasoft.drones.core.dto.MedicationItemDTO;
import com.musalasoft.drones.core.service.IDispatchService;
import com.musalasoft.drones.core.service.IDroneService;
import com.musalasoft.drones.core.service.IMedicationService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DispatchServiceImpl implements IDispatchService {

    private final IDroneService droneService;

    private final IMedicationService medicationService;

    private final GeneralProperties generalProperties;

    @Override
    public LoadDTO load(Integer droneId, List<Integer> listMedicationIds) {

        DroneDTO droneDTO = droneService.get(droneId).orElse(null);

        if (Objects.isNull(droneDTO)) {
            throw new NotFoundException("Drone not found.");
        }

        if (!droneDTO.getState().equals(State.IDLE)) {
            throw new ConflictException(
                String.format(
                    "The drone can only be loaded in IDLE state. Current status of the drone [%s].",
                    droneDTO.getState().toString()
                )
            );
        }

        if (droneDTO.getBatteryCapacity() < generalProperties.getBatteryLevelBelow()) {
            throw new ConflictException(
                String.format(
                    "Drone battery level [%s] must not be less than the allowed limit [%2d].",
                    droneDTO.getBatteryCapacity(),
                    generalProperties.getBatteryLevelBelow()
                )
            );
        }

        List<MedicationDTO> listMedicationDTO = medicationService.getFindAllById(listMedicationIds);

        List<Integer> listMedicationsFinds = listMedicationDTO.stream().map(
            medicationDTO -> medicationDTO.getMedicationId()
        ).collect(Collectors.toList());

        listMedicationIds.removeAll(listMedicationsFinds);

        if (!listMedicationIds.isEmpty()) {
            throw new ConflictException(
                String.format(
                    "The following medications were not found. [%s]",
                    listMedicationIds.stream().map(String::valueOf).collect(Collectors.joining(","))
                )
            );
        }

        Integer weightTotal = listMedicationDTO.stream().mapToInt(medication -> medication.getWeight()).sum();

        if (weightTotal > droneDTO.getWeightLimit()) {
            throw new ConflictException(
                String.format(
                    "Total weight of the medications [%s] cannot exceed weight limit for the drone [%2d].",
                    weightTotal,
                    droneDTO.getWeightLimit()
                )
            );
        }

        droneDTO.setListMedicationItem(
            listMedicationDTO.stream().map(
                medicationDTO -> MedicationItemDTO.builder()
                    .medicationId(medicationDTO.getMedicationId())
                    .build()
            ).collect(Collectors.toList())
        );
        droneDTO.setState(State.LOADING);

        DroneDTO droneDTOSave = droneService.updateWithMedications(droneDTO);

        return LoadDTO.builder()
            .drone(droneDTOSave)
            .medications(listMedicationDTO)
            .build();
    }
}
