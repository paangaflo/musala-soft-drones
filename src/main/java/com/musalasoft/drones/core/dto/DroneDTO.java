package com.musalasoft.drones.core.dto;

import com.musalasoft.drones.commons.enums.Model;
import com.musalasoft.drones.commons.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDTO {

    private int droneId;
    private String serialNumber;
    private Model model;
    private int weightLimit;
    private int batteryCapacity;
    private State state;
}
