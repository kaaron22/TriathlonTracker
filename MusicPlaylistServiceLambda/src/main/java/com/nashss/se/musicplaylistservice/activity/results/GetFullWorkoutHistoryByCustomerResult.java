package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.WorkoutModel;
import com.nashss.se.musicplaylistservice.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class GetFullWorkoutHistoryByCustomerResult {

    private final List<WorkoutModel> workoutModels;

    private GetFullWorkoutHistoryByCustomerResult(List<WorkoutModel> workoutModels) {
        this.workoutModels = workoutModels;
    }

    public List<WorkoutModel> getWorkoutModels() {
        return new ArrayList<>(workoutModels);
    }

    @Override
    public String toString() {
        return "GetFullWorkoutHistoryByCustomerResult{" +
                "workoutModels=" + workoutModels +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<WorkoutModel> workoutModels;

        public Builder withTriathlonList(List<WorkoutModel> workoutModels) {
            this.workoutModels = new ArrayList<>(workoutModels);
            return this;
        }

        public GetFullWorkoutHistoryByCustomerResult build() {
            return new GetFullWorkoutHistoryByCustomerResult(workoutModels);
        }
    }


}
