package com.nashss.se.musicplaylistservice.models;

import com.nashss.se.musicplaylistservice.utils.WorkoutTypes;

import java.time.LocalDateTime;

public class TriathlonModel {

    private final String customerId;
    private final LocalDateTime timestamp;
    private final WorkoutTypes workoutType;
    private final Double duration;
    private final Double distance;

    private TriathlonModel(String customerId, LocalDateTime timestamp, WorkoutTypes workoutType, Double duration, Double distance) {
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.workoutType = workoutType;
        this.duration = duration;
        this.distance = distance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Double getDuration() {
        return duration;
    }

    public Double getDistance() {
        return distance;
    }
    //CHECKSTYLE:OFF:Builder

    public static TriathlonModel.Builder builder() {
        return new TriathlonModel.Builder();
    }

    public static class Builder {
        private String customerId;
        private LocalDateTime timestamp;
        private Double duration;
        private Double distance;

        public Builder withCustomerId(String id) {
            this.customerId = id;
            return this;
        }

    }

}



