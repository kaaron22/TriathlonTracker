package com.nashss.se.musicplaylistservice.activity.requests;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.nashss.se.musicplaylistservice.activity.results.DeleteWorkoutResult;
import com.nashss.se.musicplaylistservice.utils.LocalDateConverter;
import com.nashss.se.musicplaylistservice.utils.WorkoutType;

import java.time.LocalDate;

public class DeleteWorkoutRequest {
    private final String customerId;
    private final String date;
    private final String workoutId;


    private DeleteWorkoutRequest(String customerId, String date, String workoutId) {
        this.customerId = customerId;
        this.date = date;
        this.workoutId = workoutId;
    }
    public DeleteWorkoutRequest(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDate() {
        return this.date;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String customerId;
        private String date;
        private String workoutId;

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withWorkoutId(String workoutId) {
            this.workoutId = workoutId;
            return this;
        }

        public DeleteWorkoutRequest build() {
            return new DeleteWorkoutRequest(customerId, date, workoutId);
        }
    }
}
