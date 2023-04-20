package com.nashss.se.musicplaylistservice.activity.requests;

import java.time.LocalDate;

public class GetWorkoutRequest {
    private final String customerId;
    private final Integer numberOfDays;

    private GetWorkoutRequest(String customerId, Integer numberOfDays) {
        this.customerId = customerId;
        this.numberOfDays = numberOfDays;
    }

    public Integer getNumberOfDays() {
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
        private Integer numberOfDays;



        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withNumberOfDays(Integer numberOfDays) {
            this.numberOfDays = numberOfDays;
            return this;
        }

//        public Builder withStartDate(String startDate) {
//            this.startDate = startDate;
//            return this;
//        }

        public GetWorkoutRequest build() {
            return new GetWorkoutRequest(customerId, numberOfDays);
        }
    }
}