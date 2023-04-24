package com.nashss.se.musicplaylistservice.activity.requests;

    public class GetTypeWorkoutsRequest  {
        private final String customerId;
        private final String numberOfDays;

        private GetTypeWorkoutsRequest(String customerId, String numberOfDays) {
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
            return "GetTypeWorkoutsRequest{" +
                    "customerId='" + customerId + '\'' +
                    ", numberOfDays='" + numberOfDays + '\'' +
                    '}';
        }

        //CHECKSTYLE:OFF:Builder
        public static com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest.Builder builder() {
            return new com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest.Builder();
        }

        public static class Builder {
            private String customerId;
            private String numberOfDays;

            public com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest.Builder withCustomerId(String customerId) {
                this.customerId = customerId;
                return this;
            }

            public com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest.Builder withNumberOfDays(String numberOfDays) {
                this.numberOfDays = numberOfDays;
                return this;
            }

            public com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest build() {
                return new com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest(customerId, numberOfDays);
            }
        }
    }

