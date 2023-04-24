package com.nashss.se.musicplaylistservice.activity.results;

import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetTypeWorkoutsResult {
    private final Integer swimCount;
    private final Integer bikeCount;
    private final Integer runCount;
    private final String errorMessage;



    private GetTypeWorkoutsResult(Integer swimCount, Integer bikeCount, Integer runCount, String errorMessage) {
        this.swimCount = swimCount;
        this.bikeCount = bikeCount;
        this.runCount = runCount;

        this.errorMessage = errorMessage;
    }
    public Integer getSwimCount() {
        return swimCount;
    }
    public Integer getBikeCount() {
        return bikeCount;
    }
    public Integer getRunCount() {
        return runCount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    @Override
    public String toString() {
        return "GetTypeWorkoutsResult{" +
                "swimCount=" + swimCount +
                ", bikeCount=" + bikeCount +
                ", runCount=" + runCount +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult.Builder builder() {
        return new com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult.Builder();
    }

    public static class Builder {
        private Integer swimCount;
        private Integer bikeCount;
        private Integer runCount;
        private String errorMessage;
        public com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult.Builder withSwimCount(Integer swimCount) {
            this.swimCount = swimCount;
            return this;
        }
        public com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult.Builder withBikeCount(Integer bikeCount) {
            this.bikeCount = bikeCount;
            return this;
        }
        public com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult.Builder withRunCount(Integer runCount) {
            this.runCount = runCount;
            return this;
        }

        public com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult.Builder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult build() {
            return new com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult(swimCount,bikeCount,runCount, errorMessage);
        }
    }
}



