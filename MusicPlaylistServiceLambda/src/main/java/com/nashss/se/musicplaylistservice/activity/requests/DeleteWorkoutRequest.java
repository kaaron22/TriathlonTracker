package com.nashss.se.musicplaylistservice.activity.requests;


public class DeleteWorkoutRequest {
    private final String customerId;
    private final String date;
    private final String workoutId;


    private DeleteWorkoutRequest(String customerId, String date, String workoutId) {
        this.customerId = customerId;
        this.date = date;
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDate() {
        return this.date;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String customerId;
        private String date;
        private String workoutId;

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withWorkoutId(String workoutId) {
            this.workoutId = workoutId;
            return this;
        }

        public DeleteWorkoutRequest build() {
            return new DeleteWorkoutRequest(customerId, date, workoutId);
        }
    }
}
