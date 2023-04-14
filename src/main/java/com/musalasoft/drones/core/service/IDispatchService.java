package com.musalasoft.drones.core.service;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.dto.LoadDTO;
import java.util.List;

public interface IDispatchService {

    /**
     * Create a relationship between the drone and the medication list
     *
     * @param droneId {@link DroneDTO} an object that contains all the information of the drone
     * @param listMedicationIds {@link List<Integer>} an list that contains ids of the medications
     * @return loadDTO {@link LoadDTO}
     */
    LoadDTO load(Integer droneId, List<Integer> listMedicationIds);
}
