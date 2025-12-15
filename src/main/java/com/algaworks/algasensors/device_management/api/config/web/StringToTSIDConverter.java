package com.algaworks.algasensors.device_management.api.config.web;

import io.hypersistence.tsid.TSID;
import org.jspecify.annotations.Nullable;
import org.springframework.core.convert.converter.Converter;

public class StringToTSIDConverter implements Converter<String, TSID> {

    @Override
    public @Nullable TSID convert(String source) {
        return TSID.from(source);
    }
}
