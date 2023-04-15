package com.nashss.se.musicplaylistservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateWorkoutRequest.Builder.class)
public class CreateWorkoutRequest {
    private final String customerId;
    private final String customerName;
    private final String date;
    private final String workoutType;
    private final String durationInSeconds;
    private final String distance;

    public CreateWorkoutRequest(String customerId, String customerName, String date, String workoutType,
                                String durationInSeconds, String distance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.date = date;
        this.workoutType = workoutType;
        this.durationInSeconds = durationInSeconds;
        this.distance = distance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() { return customerName; }

    public String getDate() {
        return date;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public String getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "CreateWorkoutRequest{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
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
        private String customerName;
        private String date;
        private String workoutType;
        private String durationInSeconds;
        private String distance;


        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
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

        public Builder withDurationInSeconds(String durationInSeconds) {
            this.durationInSeconds = durationInSeconds;
            return this;
        }

        public Builder withDistance(String distance) {
            this.distance = distance;
            return this;
        }

        public CreateWorkoutRequest build() {
            return new CreateWorkoutRequest(customerId, customerName, date, workoutType, durationInSeconds,
                    distance);
        }
    }
}
