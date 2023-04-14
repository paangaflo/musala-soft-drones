package com.musalasoft.drones.ports.output.dao.jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DroneMedicationPK implements Serializable {

    @Column(name = "id_drone")
    private Integer idDrone;

    @Column(name = "id_medication")
    private Integer idMedication;
}
