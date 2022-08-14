package com.weather.definition;

import com.weather.JsonType;

import java.util.List;

public interface JsonFieldDefinition {

    String getKeyName();

    JsonType getValueType();

    Class<?> getValueClass();

    List<JsonFieldDefinition> getChildren();

    boolean isRequiredKeyName();

}
