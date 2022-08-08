package com.weather;

public interface JsonGenerator {

    <T> String generate(Class<T> type);
}