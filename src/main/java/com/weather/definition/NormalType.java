package com.weather.definition;

import com.weather.JsonType;

import java.util.List;

public class NormalType extends BasedDefinition{
    protected NormalType(String keyName, JsonType valueType, Class<?> valueClass) {
        super(keyName, valueType, valueClass, null);
    }
}
