package com.nashss.se.musicplaylistservice.activity.requests;


public class GetWorkoutRequest {
    private final String customerId;
    private final String numberOfDays;

    private GetWorkoutRequest(String customerId, String numberOfDays) {
        this.customerId = customerId;
        this.numberOfDays = numberOfDays;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "GetWorkoutRequest{" +
                "customerId='" + customerId + '\'' +
                ", numberOfDays='" + numberOfDays + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new GetWorkoutRequest.Builder();
    }

    public static class Builder {
        private String customerId;
        private String numberOfDays;

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withNumberOfDays(String numberOfDays) {
            this.numberOfDays = numberOfDays;
            return this;
        }

        public GetWorkoutRequest build() {
            return new GetWorkoutRequest(customerId, numberOfDays);
        }
    }
}