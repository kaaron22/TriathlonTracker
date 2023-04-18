package com.nashss.se.musicplaylistservice.activity.requests;


public class DeleteWorkoutRequest {
    private final String workoutId;


    private DeleteWorkoutRequest(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String workoutId;


        public Builder withWorkoutId(String workoutId) {
            this.workoutId = workoutId;
            return this;
        }

        public DeleteWorkoutRequest build() {
            return new DeleteWorkoutRequest(workoutId);
        }
    }
}
