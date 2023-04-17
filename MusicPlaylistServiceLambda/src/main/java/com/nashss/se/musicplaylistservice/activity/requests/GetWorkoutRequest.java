package com.nashss.se.musicplaylistservice.activity.requests;

import java.time.LocalDate;

public class GetWorkoutRequest {
    private final String customerId;
    private final String startDate;

    private GetWorkoutRequest(String customerId, String startDate) {
        this.customerId = customerId;
        this.startDate = startDate;
    }

    public String getCustomerId() {
        return customerId;
    }
    public String getStartDate(){
        return startDate;
    }

    @Override
    public String toString() {
        return "GetWorkoutRequest{" +
                "customerId='" + customerId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new GetWorkoutRequest.Builder();
    }

    public static class Builder {
        private String customerId;
        private String startDate;



        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public GetWorkoutRequest build() {
            return new GetWorkoutRequest(customerId, startDate);
        }
    }
}