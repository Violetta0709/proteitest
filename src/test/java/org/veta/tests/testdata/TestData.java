package org.veta.tests.testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private static final Faker faker = new Faker(new Locale("en"));
    public static String
            email = faker.internet().emailAddress(),
            password = faker.internet().password(),
            name = faker.name().fullName(),
            filePath = "qa-test/3.pdf";
}