package com.weather;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class JsonGeneratorTest {

    @DisplayName("1. String Type")
    @Test
    void test1(){
        JsonGenerator generator = new StandardJsonGenerator();
        String json = generator.generate(StringType.class);

        assertThat(json).isEqualTo("{" +
                        "\"test\":\"String\"" +
                "}");
    }

    static class StringType{
        private String test;
    }

    @DisplayName("2. Number Type")
    @Test
    void test2(){
        JsonGenerator generator = new StandardJsonGenerator();
        String json = generator.generate(NumberType.class);

        assertThat(json).isEqualTo("{" +
                "\"test\":1" +
                "}");
    }

    static class NumberType{
        private Integer test;
    }

    @DisplayName("3. Enum Type")
    @Test
    void test3(){
        JsonGenerator generator = new StandardJsonGenerator();
        String json = generator.generate(EnumType.class);

        assertThat(json).isEqualTo("{" +
                "\"test\":\"TYPE1\"" +
                "}");
    }

    static class EnumType{
        private TestEnum test;
    }

    static enum TestEnum{
        TYPE1,
        TYPE2;
    }
}