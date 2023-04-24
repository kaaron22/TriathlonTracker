package com.nashss.se.musicplaylistservice.activity.requests;


public class GetFullWorkoutHistoryByCustomerRequest {
    private final String customerId;

    public GetFullWorkoutHistoryByCustomerRequest(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() { return customerId; }


    @Override
    public String toString() {
        return "GetFullWorkoutHistoryByCustomerRequest{" +
                "customerId='" + customerId + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() { return new Builder(); }


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
