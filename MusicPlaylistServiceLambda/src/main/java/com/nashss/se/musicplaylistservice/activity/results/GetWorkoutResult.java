package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.SongModel;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetWorkoutResult {
    private final List<WorkoutModel> workoutModels;
    private String errorMessage;



    private GetWorkoutResult(List<WorkoutModel> workoutModels, String errorMessage) {
        this.workoutModels = workoutModels;
        this.errorMessage = errorMessage;
    }


    public List<WorkoutModel> getWorkoutModels() {
        return workoutModels == null ? Collections.emptyList() : new ArrayList<>(workoutModels);
    }

    public String getErrorMessage() {
        return errorMessage;
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
        private String errorMessage;

        public Builder withWorkoutList(List<WorkoutModel> workoutModels) {
            this.workoutModels = new ArrayList<>(workoutModels);
            return this;
        }

        public Builder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public GetWorkoutResult build() {
            return new GetWorkoutResult(workoutModels, errorMessage);
        }
    }
}

