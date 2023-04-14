package com.musalasoft.drones.ports.input.rs.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
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
public class LoadResponse {

    @Schema(description = "Id of the drone created.", example = "DroneResponse Object")
    private DroneResponse drone;

    @Schema(description = "Serial number", example = "MedicationResponse Object")
    private List<MedicationResponse> medications;
}
