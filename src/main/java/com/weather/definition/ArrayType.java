package com.weather.definition;

import com.weather.JsonType;

import java.util.List;

public class ArrayType extends BasedDefinition {
    protected ArrayType(String keyName, JsonType valueType, List<JsonFieldDefinition> children) {
        super(keyName, valueType, null, children);
    }
}
