package com.algaworks.algasensors.device_management.api.jackson;

import io.hypersistence.tsid.TSID;
import org.springframework.boot.jackson.JacksonComponent;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

@JacksonComponent
public class TSIDToStringSerializer extends ValueSerializer<TSID> {


    @Override
    public void serialize(TSID value, JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        gen.writeString(value.toString());
    }
}
