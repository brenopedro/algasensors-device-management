package com.algaworks.algasensors.device_management.api.config.jackson;

import io.hypersistence.tsid.TSID;
import org.springframework.boot.jackson.JacksonComponent;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

@JacksonComponent
public class StringToTSIDDeserializer extends ValueDeserializer<TSID> {

    @Override
    public TSID deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return TSID.from(p.getString());
    }
}
