package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.SongModel;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import java.util.ArrayList;
import java.util.List;

public class GetWorkoutResult {
    private final List<WorkoutModel> workoutList;

    private GetWorkoutResult(List<WorkoutModel> workoutList) {
        this.workoutList = workoutList;
    }

    public List<WorkoutModel> getWorkoutList() {
        return new ArrayList<>(workoutList);
    }

    @Override
    public String toString() {
        return "GetWorkoutResult{" +
                "workoutList=" + workoutList +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<WorkoutModel> workoutList;

        public Builder withWorkoutList(List<WorkoutModel> workoutList) {
            this.workoutList = new ArrayList<>(workoutList);
            return this;
        }

        public GetWorkoutResult build() {
            return new GetWorkoutResult(workoutList);
        }
    }
}

