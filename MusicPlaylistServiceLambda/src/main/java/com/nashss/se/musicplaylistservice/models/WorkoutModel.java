package com.nashss.se.musicplaylistservice.models;

import com.nashss.se.musicplaylistservice.utils.WorkoutType;

import java.time.LocalDateTime;

public class WorkoutModel {

    private final String customerId;
    private final LocalDateTime timestamp;
    private final WorkoutType workoutType;
    private Integer durationInHours;
    private Integer durationInMinutes;
    private Integer durationInSeconds;
    private final Double distance;

    private WorkoutModel(String customerId, LocalDateTime timestamp, WorkoutType workoutType,
                         Integer durationInHours, Integer durationInMinutes, Integer durationInSeconds, Double distance) {
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.workoutType = workoutType;
        this.durationInHours = durationInHours;
        this.durationInMinutes = durationInMinutes;
        this.durationInSeconds = durationInSeconds;
        this.distance = distance;
    }

    public String getUserId() {
        return customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public WorkoutType getWorkoutType() { return workoutType; }

    public Integer getDurationInHours() { return durationInHours; }

    public Integer getDurationInMinutes() { return durationInMinutes; }

    public Integer getDurationInSeconds() { return durationInSeconds; }

    public Double getDistance() {
        return distance;
    }


    //CHECKSTYLE:OFF:Builder
    public static WorkoutModel.Builder builder() {
        return new WorkoutModel.Builder();
    }

    public static class Builder {
        private String userId;
        private LocalDateTime timestamp;
        private WorkoutType workoutType;
        private Integer durationInHours;
        private Integer durationInMinutes;
        private Integer durationInSeconds;
        private Double distance;

        public WorkoutModel.Builder withUserId(String id) {
            this.userId = id;
            return this;
        }

        public WorkoutModel.Builder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public WorkoutModel.Builder withWorkoutType(WorkoutType type) {
            this.workoutType = type;
            return this;
        }

        public WorkoutModel.Builder withDurationInHours(Integer durationInHours) {
            this.durationInHours = durationInHours;
            return this;
        }

        public WorkoutModel.Builder withDurationInMinutes(Integer durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
            return this;
        }

        public WorkoutModel.Builder withDurationInSeconds(Integer durationInSeconds) {
            this.durationInSeconds = durationInSeconds;
            return this;
        }
        public WorkoutModel.Builder withDistance(Double distance) {
            this.distance = distance;
            return this;
        }

        public WorkoutModel build() { return new WorkoutModel(userId, timestamp, workoutType, durationInHours,
                durationInMinutes, durationInSeconds, distance); }

    }

}