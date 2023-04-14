package com.musalasoft.drones.core.service.impl;

import com.musalasoft.drones.core.dto.MedicationDTO;
import com.musalasoft.drones.core.mapper.MedicationMapper;
import com.musalasoft.drones.core.service.IMedicationService;
import com.musalasoft.drones.ports.output.dao.jpa.entity.Medication;
import com.musalasoft.drones.ports.output.dao.jpa.repo.MedicationRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements IMedicationService {

    private final MedicationRepository medicationRepository;

    private final MedicationMapper medicationMapper;

    @Override
    public MedicationDTO save(MedicationDTO medicationDTO) {
        Medication medication = medicationMapper.dtoToEntity(medicationDTO);
        return medicationMapper.entityToDto(medicationRepository.save(medication));
    }

    @Override
    public boolean delete(Integer medicationId) {
        return get(medicationId).map(medication -> {
            medicationRepository.deleteById(medication.getMedicationId());
            return true;
        }).orElse(false);
    }

    @Override
    public List<MedicationDTO> getAll() {
        return medicationMapper.toListMedicationDto((List<Medication>) medicationRepository.findAll());
    }

    @Override
    public Optional<MedicationDTO> get(Integer medicationId) {
        return medicationRepository.findById(medicationId).map(medication -> medicationMapper.entityToDto(medication));
    }

    @Override
    public List<MedicationDTO> getFindAllById(List<Integer> listMedicationIds) {
        return medicationMapper.toListMedicationDto(
            (List<Medication>) medicationRepository.findAllById(listMedicationIds)
        );
    }
}
