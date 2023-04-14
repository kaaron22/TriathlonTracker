package com.nashss.se.musicplaylistservice.activity.requests;

import com.nashss.se.musicplaylistservice.utils.WorkoutType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;


@JsonDeserialize(builder = CreatePlaylistRequest.Builder.class)
public class CreateWorkoutRequest {
    private final String customerId;
    private final LocalDate date;
    private final WorkoutType workoutType;
    private final Integer durationInSeconds;
    private final Double distance;

    public CreateWorkoutRequest(String customerId, LocalDate date, WorkoutType workoutType,
                                Integer durationInSeconds, Double distance) {
        this.customerId = customerId;
        this.date = date;
        this.workoutType = workoutType;
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

        public Builder withWorkoutType(String workoutType) {
            this.workoutType = WorkoutType.valueOf(workoutType);
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
            return new CreateWorkoutRequest(customerId, date, workoutType, durationInSeconds,
                    distance);
        }
    }
}
