package com.weather;

import com.weather.printer.FieldPrinter;
import com.weather.printer.GenericPrinter;
import com.weather.value.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class JsonGeneratorTest {

    FieldPrinter fieldPrinter;
    GenericPrinter genericPrinter;
    JsonGenerator generator;

    @BeforeEach
    public void init() {
        List<ValueGenerator> generators = new ArrayList<>();
        generators.add(new StringGenerator());
        generators.add(new NumberGenerator());
        generators.add(new BooleanGenerator());
        generators.add(new EnumGenerator());
        generators.add(new LocalDateGenerator());
        generators.add(new LocalTimeGenerator());
        generators.add(new LocalDateTimeGenerator());

        generator = new StandardJsonGenerator(generators);
    }

    @DisplayName("1. String Type")
    @Test
    void test1() {
        String json = generator.generate(StringType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                "\"test\":\"String\"" +
                "}");
    }

    static class StringType {
        private String test;
    }

    @DisplayName("2. Number Type")
    @Test
    void test2() {
        String json = generator.generate(NumberType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                "\"test\":1" +
                "}");
    }

    static class NumberType {
        private Integer test;
    }

    @DisplayName("3. Boolean Test")
    @Test
    void test3() {
        String json = generator.generate(BooleanType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                "\"test\":true" +
                "}");
    }

    static class BooleanType {
        private Boolean test;
    }

    @DisplayName("4. Array Type")
    @Test
    void test4() {
        String json = generator.generate(ArrayType.class);

        System.out.println(arrayTestJson());
        assertThat(json).isEqualTo(arrayTestJson());
    }

    private String arrayTestJson() {
        return "{" +
                "\"test\":[" +
                "[" +
                "1" +
                "]" +
                "]" +
                "}";
    }

    static class ArrayType {
        private List<List<Integer>> test;
    }

    @DisplayName("5. Enum Type")
    @Test
    void test5() {
        String json = generator.generate(EnumType.class);

        assertThat(json).isEqualTo(enumJson());
    }

    @NotNull
    private String enumJson() {
        return "{" +
                "\"test\":\"TYPE1\"" +
                "}";
    }

    static class EnumType {
        private TestEnum test;
    }

    static enum TestEnum {
        TYPE1,
        TYPE2;
    }

    @DisplayName("6. Integration")
    @Test
    void test6() {
        String json = generator.generate(Member.class);

        System.out.println(json);
        assertThat(json).isEqualTo(integrationJson());
    }

    static class Member {
        private String name;
        private int age;
        private Address address;
        private boolean gender;
        private List<Belonging> belongings;
    }

    static class Address {
        private String state;
        private String city;
        private String street;
    }

    static class Belonging {
        private String name;
        private int count;
    }

    String integrationJson() {
        return "{" +
                "\"name\":\"String\"," +
                "\"age\":1," +
                "\"address\":{" +
                "\"state\":\"String\"," +
                "\"city\":\"String\"," +
                "\"street\":\"String\"" +
                "}," +
                "\"gender\":true," +
                "\"belongings\":[{" +
                "\"name\":\"String\"," +
                "\"count\":1" +
                "}]" +
                "}";
    }

    @DisplayName("7. LocalDate")
    @Test
    void test7() {
        String json = generator.generate(LocalDateType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"9999-12-31\"}");
    }

    static class LocalDateType {
        private LocalDate test;
    }

    @DisplayName("8. LocalTime")
    @Test
    void test8() {
        String json = generator.generate(LocalTimeType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"12:00:00.123456\"}");
    }

    static class LocalTimeType {
        private LocalTime test;
    }

    @DisplayName("9. LocalDateTime")
    @Test
    void test9() {
        String json = generator.generate(LocalDateTimeType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"9999-12-31T12:00:00.123456\"}");
    }

    static class LocalDateTimeType {
        private LocalDateTime test;
    }
}