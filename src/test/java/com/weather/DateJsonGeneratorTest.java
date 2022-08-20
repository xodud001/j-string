package com.weather;

import com.weather.value.*;
import com.weather.value.date.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DateJsonGeneratorTest {

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
        generators.add(new ZonedDateTimeGenerator());
        generators.add(new InstantGenerator());

        generator = new StandardJsonGenerator(generators);
    }

    @DisplayName("1. LocalDate")
    @Test
    void test7() {
        String json = generator.generate(LocalDateType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"9999-12-31\"}");
    }

    static class LocalDateType {
        private LocalDate test;
    }

    @DisplayName("2. LocalTime")
    @Test
    void test8() {
        String json = generator.generate(LocalTimeType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"12:00:00.123456\"}");
    }

    static class LocalTimeType {
        private LocalTime test;
    }

    @DisplayName("3. LocalDateTime")
    @Test
    void test9() {
        String json = generator.generate(LocalDateTimeType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"9999-12-31T12:00:00.123456\"}");
    }

    static class LocalDateTimeType {
        private LocalDateTime test;
    }

    @DisplayName("4. ZonedDateTime")
    @Test
    void test10() {
        String json = generator.generate(ZonedDateTimeType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"9999-12-31T12:00:00.123456+09:00\"}");
    }

    static class ZonedDateTimeType {
        private ZonedDateTime test;
    }

    @DisplayName("5. Instant")
    @Test
    void test11() {
        String json = generator.generate(InstantType.class);
        System.out.println(json);

        assertThat(json).isEqualTo("{\"test\":\"9999-12-31T12:00:00.123456Z\"}");
    }

    static class InstantType {
        private Instant test;
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
        private Local local;
        private ZonedDateTime zonedDateTime;
        private Instant instant;
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

    static class Local {
        private LocalDate localDate;
        private LocalDateTime localDateTime;
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
                "}]," +
                "\"local\":{" +
                "\"localDate\":\"9999-12-31\"," +
                "\"localDateTime\":\"9999-12-31T12:00:00.123456\"" +
                "}," +
                "\"zonedDateTime\":\"9999-12-31T12:00:00.123456+09:00\"," +
                "\"instant\":\"9999-12-31T12:00:00.123456Z\"" +
                "}";
    }
}
