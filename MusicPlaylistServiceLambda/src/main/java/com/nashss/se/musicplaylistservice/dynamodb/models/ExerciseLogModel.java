package com.nashss.se.musicplaylistservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "exercise_log")
public class ExerciseLogModel {
    private String customerId;
    private String timestamp;
    private String description;
    private Double caloriesBurned;
    private Integer numReps;
    private Double numSets;
    private Double duration;
    private Double distance;

    @DynamoDBHashKey(attributeName = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute(attributeName = "calories_burned")
    public Double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @DynamoDBAttribute(attributeName = "repetitions")
    public Integer getNumReps() {
        return numReps;
    }

    public void setNumReps(Integer numReps) {
        this.numReps = numReps;
    }

    @DynamoDBAttribute(attributeName = "set_number")
    public Double getNumSets() {
        return numSets;
    }

    public void setNumSets(Double numSets) {
        this.numSets = numSets;
    }

    @DynamoDBAttribute(attributeName = "duration")
    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @DynamoDBAttribute(attributeName = "distance")
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseLogModel that = (ExerciseLogModel) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(timestamp, that.timestamp) && Objects.equals(description, that.description) && Objects.equals(caloriesBurned, that.caloriesBurned) && Objects.equals(numReps, that.numReps) && Objects.equals(numSets, that.numSets) && Objects.equals(duration, that.duration) && Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, timestamp, description, caloriesBurned, numReps, numSets, duration, distance);
    }

}
