package com.musalasoft.drones;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = DispatchServiceApplication.class, webEnvironment = RANDOM_PORT)
@ActiveProfiles({"test"})
public abstract class AbstractIntegrationTest {

}
