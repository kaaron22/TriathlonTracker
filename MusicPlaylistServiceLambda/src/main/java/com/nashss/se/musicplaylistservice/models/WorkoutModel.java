package com.nashss.se.musicplaylistservice.models;

public class WorkoutModel {

    private final String customerId;
    private final String date;
    private final String workoutType;
    private final Integer durationInSeconds;
    private final Double distance;

    private WorkoutModel(String customerId, String date, String workoutType, Integer durationInSeconds,
                         Double distance) {
        this.customerId = customerId;
        this.date = date;
        this.workoutType = workoutType;
        this.durationInSeconds = durationInSeconds;
        this.distance = distance;
    }

    public String getUserId() {
        return customerId;
    }

    public String getDate() {
        return date;
    }

    public String getWorkoutType() {
        return workoutType;
    }


    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public Double getDistance() {
        return distance;
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new WorkoutModel.Builder();
    }

    public static class Builder {
        private String userId;
        private String date;
        private String workoutType;
        private Integer durationInSeconds;
        private Double distance;

        public Builder withUserId(String id) {
            this.userId = id;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withWorkoutType(String type) {
            this.workoutType = type;
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

        public WorkoutModel build() {
            return new WorkoutModel(userId, date, workoutType, durationInSeconds, distance);
        }

    }
}
