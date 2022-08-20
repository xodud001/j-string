package com.weather.value.date;

import com.weather.value.ValueGenerator;

import java.time.Instant;

public class InstantGenerator implements ValueGenerator {

    @Override
    public String generate(Class<?> type) {
        return String.format("\"%s\"", "9999-12-31T12:00:00.123456Z");
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return Instant.class.isAssignableFrom(type);
    }
}
