package com.algaworks.algasensors.device_management.api.client.impl;

import com.algaworks.algasensors.device_management.api.client.SensorMonitoringClient;
import com.algaworks.algasensors.device_management.api.client.SensorMonitoringClientBadGatewayException;
import io.hypersistence.tsid.TSID;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SensorMonitoringClientImpl implements SensorMonitoringClient {

    private final RestClient restClient;

    public SensorMonitoringClientImpl() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8082")
                .defaultStatusHandler(HttpStatusCode::isError,
                        (request, response) -> {
                            throw new SensorMonitoringClientBadGatewayException();
                        })
                .build();
    }

    @Override
    public void enableMonitoring(TSID sensorId) {
        restClient.put()
                .uri("/api/sensors/{sensorId}/monitoring/enable", sensorId.toString())
                .retrieve()
                .toBodilessEntity();
    }

    @Override
    public void disableMonitoring(TSID sensorId) {
        restClient.delete()
                .uri("/api/sensors/{sensorId}/monitoring/enable", sensorId.toString())
                .retrieve()
                .toBodilessEntity();
    }
}
