package com.algaworks.algasensors.device_management.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorDetailOutput {

    private SensorOutput sensor;
    private SensorMonitoringOutput monitoring;
}
