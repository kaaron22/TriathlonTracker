package com.nashss.se.musicplaylistservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = CreatePlaylistRequest.Builder.class)
public class CreateWorkoutRequest {
    private final String customerId;
    private final String date;
    private final String workoutType;
    private Integer durationInHours;
    private Integer durationInMinutes;
    private Integer durationInSeconds;
    private final Double distance;

    public CreateWorkoutRequest(String customerId, String date, String workoutType, Integer durationInHours,
                                Integer durationInMinutes, Integer durationInSeconds, Double distance) {
        this.customerId = customerId;
        this.date = date;
        this.workoutType = workoutType;
        this.durationInHours = durationInHours;
        this.durationInMinutes = durationInMinutes;
        this.durationInSeconds = durationInSeconds;
        this.distance = distance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDate() {
        return date;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public Double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "CreateWorkoutRequest{" +
                "customerId='" + customerId + '\'' +
                ", date='" + date + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", durationInHours=" + durationInHours +
                ", durationInMinutes=" + durationInMinutes +
                ", durationInSeconds=" + durationInSeconds +
                ", distance=" + distance +
                '}';
    }
}
