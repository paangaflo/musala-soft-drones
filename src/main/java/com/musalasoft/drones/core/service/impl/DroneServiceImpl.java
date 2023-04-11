package com.musalasoft.drones.core.service.impl;

import com.musalasoft.drones.commons.enums.State;
import com.musalasoft.drones.config.property.GeneralProperties;
import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.mapper.DroneMapper;
import com.musalasoft.drones.core.service.IDroneService;
import com.musalasoft.drones.ports.output.dao.jpa.entity.Drone;
import com.musalasoft.drones.ports.output.dao.jpa.repo.DroneRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements IDroneService {

    private final DroneRepository droneRepository;

    private final DroneMapper droneMapper;

    private final GeneralProperties generalProperties;

    @Override
    public DroneDTO createDrone(DroneDTO droneDTO) {
        Drone drone = droneMapper.dtoToEntity(droneDTO);
        drone.setBatteryCapacity(generalProperties.getDefaultBatteryCapacity());
        drone.setState(State.IDLE);
        return droneMapper.entityToDto(droneRepository.save(drone));
    }

    @Override
    public List<DroneDTO> getAll() {
        return droneMapper.listEntityToListDto((List<Drone>) droneRepository.findAll());
    }

    @Override
    public Optional<DroneDTO> getDrone(Integer droneId) {
        return droneRepository.findById(droneId).map(drone -> droneMapper.entityToDto(drone));
    }
}
