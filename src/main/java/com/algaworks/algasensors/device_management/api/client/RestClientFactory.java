package com.algaworks.algasensors.device_management.api.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Component
public class RestClientFactory {

    public RestClient temperatureMonitoringRestClient() {
        return RestClient.builder()
                .requestFactory(generateClientHttpRequestFactory())
                .baseUrl("http://localhost:8082")
                .defaultStatusHandler(HttpStatusCode::isError,
                        (request, response) -> {
                            throw new SensorMonitoringClientBadGatewayException();
                        })
                .build();
    }

    private ClientHttpRequestFactory generateClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(Duration.ofSeconds(3));
        factory.setReadTimeout(Duration.ofSeconds(5));

        return factory;
    }
}
