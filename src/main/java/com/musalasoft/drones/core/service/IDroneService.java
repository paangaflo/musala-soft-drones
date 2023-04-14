package com.musalasoft.drones.core.service;

import com.musalasoft.drones.core.dto.DroneDTO;
import java.util.List;
import java.util.Optional;

public interface IDroneService {

    /**
     * Create a drone
     *
     * @param droneDTO {@link DroneDTO} an object to start to perform of creating a drone
     * @return droneDTO {@link DroneDTO}
     */
    DroneDTO save(DroneDTO droneDTO);

    /**
     * Delete a drone for id
     *
     * @param droneId {@link Integer} id unique of drone
     */
    boolean delete(Integer droneId);

    /**
     * Get all drones
     *
     * @return List<DroneDTO> {@link List<DroneDTO>}
     */
    List<DroneDTO> getAll();

    /**
     * Get a drone for the specified id
     *
     * @param droneId {@link Integer} id unique of drone
     * @return Optional<DroneDTO> {@link Optional<DroneDTO>}
     */
    Optional<DroneDTO> get(Integer droneId);

    /**
     * Update a drone with medications
     *
     * @param droneDTO {@link DroneDTO} an object to start to perform of update a drone
     * @return droneDTO {@link DroneDTO}
     */
    DroneDTO updateWithMedications(DroneDTO droneDTO);

    /**
     * Update the battery level of a drone
     *
     * @param droneDTO {@link DroneDTO} an object to start to perform of update a drone
     */
    void updateBatteryLevelDrone(DroneDTO droneDTO);
}
