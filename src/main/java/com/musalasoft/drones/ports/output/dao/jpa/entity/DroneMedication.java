package com.musalasoft.drones.ports.output.dao.jpa.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drone_medication")
public class DroneMedication implements Serializable {

    @EmbeddedId
    private DroneMedicationPK id;

    @ManyToOne
    @MapsId("idDrone")
    @JoinColumn(name = "id_drone", insertable = false, updatable = false)
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "id_medication", insertable = false, updatable = false)
    private Medication medication;
}
