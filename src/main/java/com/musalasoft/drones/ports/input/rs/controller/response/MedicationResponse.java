package com.musalasoft.drones.ports.input.rs.controller.response;

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
public class MedicationResponse {

    @Schema(description = "Id of the medication created.", example = "1")
    private Integer medicationId;

    @Schema(description = "Name of medication", requiredMode = Schema.RequiredMode.REQUIRED, example = "Aspirin")
    private String name;

    @Schema(description = "Weight of medication", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer weight;

    @Schema(description = "Code to identify medication", requiredMode = Schema.RequiredMode.REQUIRED,
        example = "ER_45-ERT")
    private String code;

    @Schema(description = "Path to imagen of medication", requiredMode = Schema.RequiredMode.REQUIRED,
        example = "https://www.somedomain.com/image.png")
    private String image;
}
