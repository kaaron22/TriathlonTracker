package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.WorkoutModel;

public class DeleteWorkoutResult {

    private final WorkoutModel workout;

    private DeleteWorkoutResult(WorkoutModel workout) {
        this.workout = workout;
    }

    public WorkoutModel getWorkout() {
        return workout;
    }

    @Override
    public String toString() {
        return "DeleteWorkoutResult{" +
                "workout=" + workout +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private WorkoutModel workout;

        public Builder withTriathlon(WorkoutModel workout) {
            this.workout = workout;
            return this;
        }



        public DeleteWorkoutResult build() {
            return new DeleteWorkoutResult(workout);
        }
    }
}
