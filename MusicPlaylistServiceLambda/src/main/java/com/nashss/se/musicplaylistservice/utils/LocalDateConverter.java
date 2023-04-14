package com.nashss.se.musicplaylistservice.utils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    private static final String ISO_DATE_FORMAT= "yyyy-MM-dd";

    @Override
    public String convert(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(ISO_DATE_FORMAT));
    }

    @Override
    public LocalDate unconvert(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(ISO_DATE_FORMAT));
    }
}
