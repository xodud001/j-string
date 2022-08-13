package com.weather.definition;

import com.weather.JsonType;

public interface JsonFieldDefinition {

    String getKeyName();

    JsonType getValueType();

    boolean hasChild();

    boolean isRequiredKeyName();

}
