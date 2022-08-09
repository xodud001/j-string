package com.weather.field;

import java.lang.reflect.Field;

public abstract class AbstractFieldGenerator implements FieldGenerator{

    @Override
    public String generateField(Field field) {
        String key = createKey(field);
        String value = createValue(field);

        return key + ":" + value;
    }

    private String createKey(Field field) {
        return "\"" + field.getName() + "\"";
    }

    protected abstract String createValue(Field field);
}
