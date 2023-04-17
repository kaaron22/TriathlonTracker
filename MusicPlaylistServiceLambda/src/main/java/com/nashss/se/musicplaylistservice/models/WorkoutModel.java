package com.nashss.se.musicplaylistservice.models;

import java.time.LocalDate;

public class WorkoutModel {

    private final String workoutId;
    private final String customerId;
    private final String customerName;
    private final LocalDate date;
    private final String workoutType;
    private final String durationInHours;
    private final String durationInMinutes;
    private final String durationInSeconds;
    private final String distance;

    private WorkoutModel(String workoutId, String customerId, String customerName, LocalDate date, String workoutType,
                         String durationInHours, String durationInMinutes, String durationInSeconds, String distance) {
        this.workoutId = workoutId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.date = date;
        this.workoutType = workoutType;
        this.durationInHours = durationInHours;
        this.durationInMinutes = durationInMinutes;
        this.durationInSeconds = durationInSeconds;
        this.distance = distance;
    }

    public String getCustomerName() { return customerName; }

    public String getCustomerId() {
        return customerId;
    }

    public String getWorkoutId() { return workoutId; }

    public LocalDate getDate() {
        return date;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public String getDurationInHours() {
        return durationInHours;
    }

    public String getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getDistance() {
        return distance;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new WorkoutModel.Builder();
    }

    public static class Builder {
        private String workoutId;
        private String customerId;
        private String customerName;
        private LocalDate date;
        private String workoutType;
        private String durationInHours;
        private String durationInMinutes;
        private String durationInSeconds;
        private String distance;

        public Builder withWorkoutId(String workoutId) {
            this.workoutId = workoutId;
            return this;
        }

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withWorkoutType(String type) {
            this.workoutType = type;
            return this;
        }

        public Builder withDurationInHours(String durationInHours) {
            this.durationInHours = durationInHours;
            return this;
        }

        public Builder withDurationInMinutes(String durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
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

        public WorkoutModel build() {
            return new WorkoutModel(workoutId, customerId, customerName, date, workoutType, durationInHours,
                    durationInMinutes, durationInSeconds, distance);
        }

    }
}
