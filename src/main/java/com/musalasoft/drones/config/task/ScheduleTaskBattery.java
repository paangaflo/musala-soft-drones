package com.musalasoft.drones.config.task;

import com.musalasoft.drones.core.dto.DroneDTO;
import com.musalasoft.drones.core.service.IDroneService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleTaskBattery {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskBattery.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final IDroneService droneService;

    @Scheduled(fixedRateString  = "${musalasoft.scheduled-job-delay}")
    public void scheduleCheckDronesBatteryLevelTask() {
        List<DroneDTO> listDroneDTO = droneService.getAll();
        logger.info("Drones Battery levels :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
        for(DroneDTO droneDTO : listDroneDTO)
        {
            logger.info("Drone :: {}, Battery Level :: {}%", droneDTO.getDroneId(), droneDTO.getBatteryCapacity());
        }
    }
}
