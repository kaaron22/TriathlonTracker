package com.nashss.se.musicplaylistservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = GetFullWorkoutHistoryByCustomerRequest.class)
public class GetFullWorkoutHistoryByCustomerRequest {
    private final String customerId;

    public GetFullWorkoutHistoryByCustomerRequest(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() { return customerId; }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }

    @JsonPOJOBuilder
    public static class Builder {
        private String customerId;

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public GetFullWorkoutHistoryByCustomerRequest build() {
            return new GetFullWorkoutHistoryByCustomerRequest(customerId);
        }
    }
}
