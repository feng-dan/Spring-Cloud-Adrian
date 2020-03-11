package com.adrian.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author feng-dan
 */
@EnableAdminServer
@SpringBootApplication
public class AdrianMonitorAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdrianMonitorAdminApplication.class, args);
    }
}
