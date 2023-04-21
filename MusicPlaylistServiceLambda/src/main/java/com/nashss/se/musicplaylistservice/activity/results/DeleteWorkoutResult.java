package com.nashss.se.musicplaylistservice.activity.results;


public class DeleteWorkoutResult {

    private final String workoutId;

    private DeleteWorkoutResult(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String workoutId;

        public Builder withWorkoutId(String workoutId) {
            this.workoutId = workoutId;
            return this;
        }


        public DeleteWorkoutResult build() {
            return new DeleteWorkoutResult(workoutId);
        }
    }

    @Override
    public String toString() {
        return "DeleteWorkoutResult{" +
                "workoutId='" + workoutId + '\'' +
                '}';
    }
}
