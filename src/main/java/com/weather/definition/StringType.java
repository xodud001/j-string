package com.weather.definition;

import com.weather.JsonType;

public class StringType implements JsonFieldDefinition {



    @Override
    public String getKeyName() {
        return null;
    }

    @Override
    public JsonType getValueType() {
        return null;
    }

    @Override
    public boolean hasChild() {
        return false;
    }

    @Override
    public boolean isRequiredKeyName() {
        return false;
    }
}
