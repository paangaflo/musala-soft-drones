--liquibase formatted sql

--changeset nvoxland:1
CREATE TABLE drone (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(100) NOT NULL,
    model ENUM('LIGHT_WEIGHT', 'MIDDLE_WEIGHT', 'CRUISER_WEIGHT', 'HEAVY_WEIGHT') NOT NULL,
    weight_limit INT NOT NULL,
    battery_capacity INT DEFAULT 0,
    state ENUM('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING') NOT NULL
);
--rollback DROP TABLE drone;

--changeset nvoxland:2
CREATE TABLE medication (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    weight INT NOT NULL,
    code VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL
);
--rollback DROP TABLE medication;

--changeset nvoxland:3
CREATE TABLE drone_medication (
    id_drone INT NOT NULL,
    id_medication INT NOT NULL,
    CONSTRAINT FK_DroneMedicationToDrone FOREIGN KEY (id_drone) REFERENCES drone (id),
    CONSTRAINT FK_DroneMedicationToMedication FOREIGN KEY (id_medication) REFERENCES medication (id),
    PRIMARY KEY (id_drone, id_medication)
);
--rollback DROP TABLE drone_medication;