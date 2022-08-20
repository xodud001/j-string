package com.weather.value.date;

import com.weather.value.ValueGenerator;

import java.time.ZonedDateTime;

public class ZonedDateTimeGenerator implements ValueGenerator {

    @Override
    public String generate(Class<?> type) {
        return String.format("\"%s\"", "9999-12-31T12:00:00.123456+09:00");
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return ZonedDateTime.class.isAssignableFrom(type);
    }
}
