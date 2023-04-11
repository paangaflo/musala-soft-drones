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
    DroneDTO createDrone(DroneDTO droneDTO);

    /**
     * List all drones
     *
     * @return List<droneDTO> {@link List<DroneDTO>}
     */
    List<DroneDTO> getAll();

    /**
     * Get a drone for the specified id
     *
     * @param droneId {@link Integer}
     * @return Optional<droneDTO> {@link Optional<DroneDTO>}
     */
    Optional<DroneDTO> getDrone(Integer droneId);
}
