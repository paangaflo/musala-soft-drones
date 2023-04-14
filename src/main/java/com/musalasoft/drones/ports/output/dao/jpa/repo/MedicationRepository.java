package com.musalasoft.drones.ports.output.dao.jpa.repo;

import com.musalasoft.drones.ports.output.dao.jpa.entity.Medication;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends CrudRepository<Medication, Integer> {
}
