package com.weather.value;

public interface
ValueGenerator {

    String generate(Class<?> type);

    boolean isSupported(Class<?> type);
}
