package com.musalasoft.drones.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "musalasoft.general")
public class GeneralProperties {

    private Integer limitDrones;
    private Integer defaultBatteryCapacity;
    private Integer batteryLevelBelow;

}
