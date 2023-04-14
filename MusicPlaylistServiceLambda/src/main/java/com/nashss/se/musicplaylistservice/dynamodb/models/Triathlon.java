package com.nashss.se.musicplaylistservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.nashss.se.musicplaylistservice.converters.LocalDateConverter;

@DynamoDBTable(tableName = "triathlon")
public class Triathlon {
    private String userId;
    private String workoutId;
    private String date;
    private String workoutType;
    private Integer durationInSeconds;
    private Double distance;

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "user_id-index", attributeName = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBHashKey(attributeName = "workout_id")
    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "date_of_workout-index", attributeName = "date_of_workout")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "workout_type-index", attributeName = "workout_type")
    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    @DynamoDBAttribute(attributeName = "seconds")
    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
    @DynamoDBAttribute(attributeName = "workout_distance")
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}