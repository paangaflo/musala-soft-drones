package com.musalasoft.drones.ports.input.rs.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.List;
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
public class LoadRequest {

    @NotNull
    @Size(min=1,max=10)
    @Schema(description = "List of medications ids to load on a drone", requiredMode = RequiredMode.NOT_REQUIRED)
    private List<Integer> medicationIds;
}
