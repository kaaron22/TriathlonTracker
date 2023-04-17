package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.WorkoutModel;
import com.nashss.se.musicplaylistservice.utils.CollectionUtils;

import java.util.List;

public class GetFullWorkoutHistoryByCustomerResult {

    private final List<WorkoutModel> workoutModels;

    private GetFullWorkoutHistoryByCustomerResult(List<WorkoutModel> workoutModels) {
        this.workoutModels = CollectionUtils.copyToList(workoutModels);
    }

    //CHECKSTYLE:OFF:Builder
    public static GetPlaylistResult.Builder builder() {
        return new GetPlaylistResult.Builder();
    }

    public static class Builder {
        private List<WorkoutModel> workoutModels;

        public Builder withWorkoutModels(List<WorkoutModel> workoutModels) {
            this.workoutModels = CollectionUtils.copyToList(workoutModels);
            return this;
        }

        public GetFullWorkoutHistoryByCustomerResult build() {
            return new GetFullWorkoutHistoryByCustomerResult(workoutModels);
        }
    }


}
