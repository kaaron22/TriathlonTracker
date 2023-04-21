package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.SongModel;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import java.util.ArrayList;
import java.util.List;

public class GetWorkoutResult {
    private final List<WorkoutModel> workoutModels;

    private GetWorkoutResult(List<WorkoutModel> workoutModels) {
        this.workoutModels = workoutModels;
    }

    public List<WorkoutModel> getWorkoutList() {
        return new ArrayList<>(workoutModels);
    }

    @Override
    public String toString() {
        return "GetWorkoutResult{" +
                "workoutModels=" + workoutModels +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<WorkoutModel> workoutModels;

        public Builder withWorkoutList(List<WorkoutModel> workoutModels) {
            this.workoutModels = new ArrayList<>(workoutModels);
            return this;
        }

        public GetWorkoutResult build() {
            return new GetWorkoutResult(workoutModels);
        }
    }
}

