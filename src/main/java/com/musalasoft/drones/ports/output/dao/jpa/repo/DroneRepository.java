package com.musalasoft.drones.ports.output.dao.jpa.repo;

import com.musalasoft.drones.ports.output.dao.jpa.entity.Drone;
import org.springframework.data.repository.CrudRepository;

public interface DroneRepository extends CrudRepository<Drone, Integer> {
}
