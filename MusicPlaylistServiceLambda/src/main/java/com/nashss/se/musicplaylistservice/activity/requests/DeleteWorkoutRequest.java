package com.nashss.se.musicplaylistservice.activity.requests;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.nashss.se.musicplaylistservice.utils.LocalDateConverter;
import com.nashss.se.musicplaylistservice.utils.WorkoutType;

import java.time.LocalDate;

@JsonDeserialize(builder = DeleteWorkoutRequest.Builder.class)
public class DeleteWorkoutRequest {

    private final String customerId;
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private final LocalDate date;
    private final WorkoutType workoutType;

    public DeleteWorkoutRequest(String customerId, LocalDate date, WorkoutType workoutType) {
        this.customerId = customerId;
        this.date = date;
        this.workoutType = workoutType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    @Override
    public String toString() {
        return "DeleteWorkoutRequest{" +
                "customerId='" + customerId + '\'' +
                ", date=" + date +
                ", workoutType=" + workoutType +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static DeleteWorkoutRequest.Builder builder() {
        return new DeleteWorkoutRequest.Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String customerId;
        private LocalDate date;
        private WorkoutType workoutType;

        public DeleteWorkoutRequest.Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public DeleteWorkoutRequest.Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public DeleteWorkoutRequest.Builder withWorkoutType(WorkoutType workoutType) {
            this.workoutType = workoutType;
            return this;
        }

        public DeleteWorkoutRequest build() {
            return new DeleteWorkoutRequest(customerId, date, workoutType);
        }
    }

}
