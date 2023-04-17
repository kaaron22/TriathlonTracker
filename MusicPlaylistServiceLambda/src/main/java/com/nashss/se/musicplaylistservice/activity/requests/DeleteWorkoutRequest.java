package com.nashss.se.musicplaylistservice.activity.requests;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.nashss.se.musicplaylistservice.utils.LocalDateConverter;
import com.nashss.se.musicplaylistservice.utils.WorkoutType;

import java.time.LocalDate;

public class DeleteWorkoutRequest {
    private String workoutId;

    public DeleteWorkoutRequest(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }
}
