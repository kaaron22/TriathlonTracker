package com.nashss.se.musicplaylistservice.activity.requests;

import com.nashss.se.musicplaylistservice.converters.LocalDateConverter;
import com.nashss.se.musicplaylistservice.utils.WorkoutType;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;


@JsonDeserialize(builder = CreatePlaylistRequest.Builder.class)
public class CreateWorkoutRequest {
    private final String customerId;
    private final LocalDate date;
    private final WorkoutType workoutType;
    private final Integer durationInHours;
    private final Integer durationInMinutes;
    private final Integer durationInSeconds;
    private final Double distance;

    public CreateWorkoutRequest(String customerId, LocalDate date, WorkoutType workoutType, Integer durationInHours,
                                Integer durationInMinutes, Integer durationInSeconds, Double distance) {
        this.customerId = customerId;
        this.date = date;
        this.workoutType = workoutType;
        this.durationInHours = durationInHours;
        this.durationInMinutes = durationInMinutes;
        this.durationInSeconds = durationInSeconds;
        this.distance = distance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public Double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "CreateWorkoutRequest{" +
                "customerId='" + customerId + '\'' +
                ", date='" + date + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", durationInHours=" + durationInHours +
                ", durationInMinutes=" + durationInMinutes +
                ", durationInSeconds=" + durationInSeconds +
                ", distance=" + distance +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String customerId;
        private LocalDate date;
        private WorkoutType workoutType;
        private Integer durationInHours;
        private Integer durationInMinutes;
        private Integer durationInSeconds;
        private Double distance;


        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withWorkoutType(WorkoutType workoutType) {
            this.workoutType = workoutType;
            return this;
        }

        public Builder withDurationInHours(Integer durationInHours) {
            this.durationInHours = durationInHours;
            return this;
        }

        public Builder withDurationInMinutes(Integer durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
            return this;
        }

        public Builder withDurationInSeconds(Integer durationInSeconds) {
            this.durationInSeconds = durationInSeconds;
            return this;
        }

        public Builder withDistance(Double distance) {
            this.distance = distance;
            return this;
        }

        public CreateWorkoutRequest build() {
            return new CreateWorkoutRequest(customerId, date, workoutType, durationInHours, durationInMinutes,
                    durationInSeconds, distance);
        }
    }
}
