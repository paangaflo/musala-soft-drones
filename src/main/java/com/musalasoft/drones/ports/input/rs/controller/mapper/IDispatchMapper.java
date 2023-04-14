package com.musalasoft.drones.ports.input.rs.controller.mapper;

import com.musalasoft.drones.core.dto.LoadDTO;
import com.musalasoft.drones.ports.input.rs.controller.response.LoadResponse;
import org.mapstruct.Mapper;

@Mapper
public interface IDispatchMapper {
    LoadResponse toLoadResponse(LoadDTO loadDTO);
}
