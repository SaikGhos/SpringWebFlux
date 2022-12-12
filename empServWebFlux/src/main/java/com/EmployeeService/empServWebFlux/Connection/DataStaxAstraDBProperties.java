package com.EmployeeService.empServWebFlux.Connection;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraDBProperties {

    private File secureConnectBundle;


    public File getSecureConnectBundle() {
        return secureConnectBundle;
    }

    public void setSecureConnectBundle(File secureConnectBundle) {
        this.secureConnectBundle = secureConnectBundle;
    }
}
