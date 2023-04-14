package com.musalasoft.drones.core.service;

import com.musalasoft.drones.core.dto.MedicationDTO;
import java.util.List;
import java.util.Optional;

public interface IMedicationService {

    /**
     * Create a medication
     *
     * @param medicationDTO {@link MedicationDTO} an object to start to perform of creating a medication
     * @return medicationDTO {@link MedicationDTO}
     */
    MedicationDTO save(MedicationDTO medicationDTO);

    /**
     * Delete a medication for id
     *
     * @param medicationId {@link Integer} id unique of medication
     */
    boolean delete(Integer medicationId);

    /**
     * Get all medications
     *
     * @return List<MedicationDTO> {@link List<MedicationDTO>}
     */
    List<MedicationDTO> getAll();

    /**
     * Get a medication for the specified id
     *
     * @param medicationId {@link Integer} id unique of medication
     * @return optional<MedicationDTO> {@link Optional<MedicationDTO>}
     */
    Optional<MedicationDTO> get(Integer medicationId);

    /**
     * Get all medications for the specified id
     *
     * @param listMedicationIds {@link List<Integer>} list with id unique of medication
     * @return List<MedicationDTO> {@link List<MedicationDTO>}
     */
    List<MedicationDTO> getFindAllById(List<Integer> listMedicationIds);
}
