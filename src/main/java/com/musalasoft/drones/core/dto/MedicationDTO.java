package com.musalasoft.drones.core.dto;

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
public class MedicationDTO {

    private int medicationId;
    private String name;
    private int weight;
    private String code;
    private String image;
}
