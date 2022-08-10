package com.weather.field.impl;

import com.weather.JsonGenerator;
import com.weather.field.AbstractFieldGenerator;

import java.lang.reflect.Field;
import java.util.Collection;

public class CollectionGenerator extends AbstractFieldGenerator {

    @Override
    protected String createValue(JsonGenerator jsonGenerator, Field field) {
        return null;
    }

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return Collection.class.isAssignableFrom(fieldType);
    }
}
