package com.musalasoft.drones.ports.input.rs.controller.request;

import com.musalasoft.drones.commons.enums.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class DroneRequest {

    @NotEmpty
    @Size(max = 100)
    @Schema(description = "Serial number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ASDE-ER45-E345")
    private String serialNumber;

    @NotNull
    @Schema(description = "Registered model type for the drone", requiredMode = Schema.RequiredMode.REQUIRED,
        example = "LIGHT_WEIGHT", allowableValues = {"LIGHT_WEIGHT", "MIDDLE_WEIGHT", "CRUISER_WEIGHT", "HEAVY_WEIGHT"})
    private Model model;

    @NotNull
    @Max(500)
    @Schema(description = "Maximum weight limit allowed for drone cargo", requiredMode = Schema.RequiredMode.REQUIRED,
        example = "500")
    private Integer weightLimit;
}
