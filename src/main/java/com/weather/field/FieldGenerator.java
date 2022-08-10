package com.weather.field;

import com.weather.JsonGenerator;

import java.lang.reflect.Field;

public interface FieldGenerator {

    String generateField(JsonGenerator jsonGenerator, Field field);

    boolean isSupported(Class<?> fieldType);
}
