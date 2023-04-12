package com.nashss.se.musicplaylistservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreatePlaylistRequest.Builder.class)
public class CreateWorkoutRequest {
    private final String customerId;
    private final String date;
    private final String workoutType;
    private final Integer durationInHours;
    private final Integer durationInMinutes;
    private final Integer durationInSeconds;
    private final Double distance;

    public CreateWorkoutRequest(String customerId, String date, String workoutType, Integer durationInHours,
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

    public String getDate() {
        return date;
    }

    public String getWorkoutType() {
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
        private String date;
        private String workoutType;
        private Integer durationInHours;
        private Integer durationInMinutes;
        private Integer durationInSeconds;
        private Double distance;


        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withWorkoutType(String workoutType) {
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
