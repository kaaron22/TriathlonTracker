package com.nashss.se.musicplaylistservice.activity.requests;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeleteWorkoutRequest.Builder.class)
public class DeleteWorkoutRequest {
    private final String workoutId;
    private final String customerId;

    private DeleteWorkoutRequest(String workoutId, String customerId) {
        this.workoutId = workoutId;
        this.customerId = customerId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public String getCustomerId() {
        return customerId;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String workoutId;
        private String customerId;


        public Builder withWorkoutId(String workoutId) {
            this.workoutId = workoutId;
            return this;
        }

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public DeleteWorkoutRequest build() {
            return new DeleteWorkoutRequest(workoutId, customerId);
        }
    }
}
