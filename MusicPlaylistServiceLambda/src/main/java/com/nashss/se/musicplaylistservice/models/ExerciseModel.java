package com.nashss.se.musicplaylistservice.models;

import java.time.LocalDateTime;

public class ExerciseModel {

    private final String customerId;
    private final LocalDateTime timestamp;
    private final String description;
    private final Double caloriesBurned;
    private final Integer numReps;
    private final Double numSets;
    private final Double duration;
    private final Double distance;

    private ExerciseModel(String customerId, LocalDateTime timestamp, String description, Double caloriesBurned, Integer numReps,
                          Double numSets, Double duration, Double distance) {
        this.customerId = customerId;
        this.timestamp = timestamp;
        this.description = description;
        this.caloriesBurned = caloriesBurned;
        this.numReps = numReps;
        this.numSets = numSets;
        this.duration = duration;
        this.distance = distance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public Double getCaloriesBurned() {
        return caloriesBurned;
    }

    public Integer getNumReps() {
        return numReps;
    }

    public Double getNumSets() {
        return numSets;
    }

    public Double getDuration() {
        return duration;
    }

    public Double getDistance() {
        return distance;
    }
    //CHECKSTYLE:OFF:Builder
    public static ExerciseModel.Builder builder() {
        return new ExerciseModel.Builder();
    }

    public static class Builder {
        private String customerId;
        private LocalDateTime timestamp;
        private String description;
        private Double caloriesBurned;
        private Integer numReps;
        private Double numSets;
        private Double duration;
        private Double distance;

        public Builder withCustomerId(String id) {
            this.customerId = id;
            return this;
        }



    }

}



