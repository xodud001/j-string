package com.weather.field.impl;

import com.weather.JsonGenerator;
import com.weather.field.AbstractFieldGenerator;

import java.lang.reflect.Field;

public class StringGenerator extends AbstractFieldGenerator {

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return String.class.equals(fieldType);
    }

    @Override
    protected String createValue(JsonGenerator jsonGenerator, Field field) {
        return "\"String\"";
    }
}
