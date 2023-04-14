package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.PlaylistModel;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

public class CreateWorkoutResult {
    private final WorkoutModel workout;

    private CreateWorkoutResult(WorkoutModel workout) {
        this.workout = workout;
    }

    public WorkoutModel getWorkoutModel() {
        return workout;
    }

    @Override
    public String toString() {
        return "CreateWorkoutResult{" +
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

        public CreateWorkoutResult build() {
            return new CreateWorkoutResult(workout);
        }
    }
}
