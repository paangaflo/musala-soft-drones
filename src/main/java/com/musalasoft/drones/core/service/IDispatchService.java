package com.musalasoft.drones.core.service;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.dto.LoadDTO;
import com.musalasoft.drones.core.dto.MedicationDTO;
import java.util.List;

public interface IDispatchService {

    /**
     * Create a relationship between the drone and the medication list
     *
     * @param droneId {@link DroneDTO} an object that contains all the information of the drone
     * @param listMedicationIds {@link List<Integer>} an list that contains ids of the medications
     * @return loadDTO {@link LoadDTO}
     */
    LoadDTO loadDrone(Integer droneId, List<Integer> listMedicationIds);

    /**
     * Get all medications for the specified drone
     *
     * @param droneId {@link Integer} id unique of drone
     * @return List<MedicationDTO> {@link List<MedicationDTO>}
     */
    List<MedicationDTO> checkMedication(Integer droneId);

    /**
     * Get all drones available for loading
     * @return List<DroneDTO> {@link List<DroneDTO>}
     */
    List<DroneDTO> availableDrone();

    /**
     * Get battery level for the specified drone
     *
     * @param droneId {@link Integer} id unique of drone
     * @return Integer {@link Integer}
     */
    Integer batteryLevelDrone(Integer droneId);
}
