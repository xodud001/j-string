package com.weather.definition;

import com.weather.JsonType;

import java.util.List;

public interface JsonFieldDefinition {

    String getKeyName();

    JsonType getValueType();

    List<JsonFieldDefinition> getChildren();

    boolean isRequiredKeyName();

}
