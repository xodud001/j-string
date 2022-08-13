package com.weather;

public interface JsonGenerator {

    <T> String generateFieldsOfType(Class<T> type);
}