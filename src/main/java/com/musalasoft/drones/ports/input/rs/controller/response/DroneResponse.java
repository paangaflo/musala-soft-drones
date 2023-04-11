package com.musalasoft.drones.ports.input.rs.controller.response;

import com.musalasoft.drones.commons.enums.Model;
import com.musalasoft.drones.commons.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class DroneResponse {

    @Schema(description = "Id of the drone created.", example = "1")
    private Integer droneId;

    @Schema(description = "Serial number", example = "ASDE-ER45-E345")
    private String serialNumber;

    @Schema(description = "Registered model type for the drone",
        example = "LIGHT_WEIGHT, MIDDLE_WEIGHT, CRUISER_WEIGHT, HEAVY_WEIGHT")
    private Model model;

    @Schema(description = "Registered model type for the drone", example = "500")
    private Integer weightLimit;

    @Schema(description = "Current percentage that have the drone battery. 0% - 100%", example = "70")
    private Integer batteryCapacity;

    @Schema(description = "Current drone status", example = "IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING")
    private State state;
}
