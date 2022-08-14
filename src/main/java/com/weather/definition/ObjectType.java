package com.weather.definition;

import com.weather.JsonType;

import java.util.List;

public class ObjectType extends BasedDefinition{

    protected ObjectType(String keyName,
                         JsonType valueType,
                         List<JsonFieldDefinition> children) {
        super(keyName, valueType, null, children);
    }
}
