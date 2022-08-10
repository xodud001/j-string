package com.weather.field;

import com.weather.JsonGenerator;

import java.lang.reflect.Field;

public abstract class AbstractFieldGenerator implements FieldGenerator{

    @Override
    public String generateField(JsonGenerator jsonGenerator, Field field) {
        String key = createKey(field);
        String value = createValue(jsonGenerator, field);

        return key + ":" + value;
    }

    private String createKey(Field field) {
        return "\"" + field.getName() + "\"";
    }

    protected abstract String createValue(JsonGenerator jsonGenerator, Field field);
}
