package com.musalasoft.drones.ports.output.dao.jpa.repo;

import com.musalasoft.drones.ports.output.dao.jpa.entity.DroneMedication;
import org.springframework.data.repository.CrudRepository;

public interface DroneMedicationRepository extends CrudRepository<DroneMedication, Integer> {
}
