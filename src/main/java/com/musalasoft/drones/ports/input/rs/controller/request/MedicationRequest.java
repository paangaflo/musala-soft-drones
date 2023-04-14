package com.musalasoft.drones.ports.input.rs.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class MedicationRequest {

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\\d_-]*$", message = "Allowed only letters, numbers, dash and underscore")
    @Schema(description = "Name of medication", requiredMode = Schema.RequiredMode.REQUIRED, example = "Aspirin")
    private String name;

    @NotNull
    @Schema(description = "Weight of medication", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer weight;

    @NotEmpty
    @Pattern(regexp = "^[A-Z\\d_]*$", message = "Allowed only upper case letters, underscore and numbers")
    @Schema(description = "Code to identify medication", requiredMode = Schema.RequiredMode.REQUIRED,
        example = "ER_45-ERT")
    private String code;

    @NotEmpty
    @Schema(description = "Path to imagen of medication", requiredMode = Schema.RequiredMode.REQUIRED,
        example = "https://www.somedomain.com/image.png")
    private String image;
}
