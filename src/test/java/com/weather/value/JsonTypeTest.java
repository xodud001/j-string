package com.weather.value;

import com.weather.JsonType;
import com.weather.exception.NotSupportedFieldException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonTypeTest {

    static class ObjectTypeTest{

    }

    @DisplayName("1. get JsonType from class type - success")
    @Test
    void test1(){
        JsonType objectType = JsonType.getJsonType(ObjectTypeTest.class);
        JsonType arrayType = JsonType.getJsonType(List.class);
        JsonType booleanType = JsonType.getJsonType(Boolean.class);
        JsonType stringType = JsonType.getJsonType(String.class);
        JsonType numberType = JsonType.getJsonType(Integer.class);

        assertThat(objectType).isEqualTo(JsonType.OBJECT);
        assertThat(arrayType).isEqualTo(JsonType.ARRAY);
        assertThat(booleanType).isEqualTo(JsonType.BOOLEAN);
        assertThat(stringType).isEqualTo(JsonType.STRING);
        assertThat(numberType).isEqualTo(JsonType.NUMBER);
    }
    @DisplayName("2. get JsonType from class type - exception")
    @Test
    void test2(){
        assertThrows(NotSupportedFieldException.class, () -> JsonType.getJsonType(java.lang.Math.class));
    }
}