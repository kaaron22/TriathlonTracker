package com.nashss.se.musicplaylistservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Objects;

@DynamoDBTable(tableName = "triathlon_table")
public class Triathlon {
    private String customerId;
    private String customerName;
    private String workoutId;
    private String date;
    private String workoutType;
    private Integer durationInSeconds;
    private Double distance;

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "CustomerIdIndex", attributeName = "customerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @DynamoDBAttribute(attributeName = "customerName")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @DynamoDBHashKey(attributeName = "workoutId")
    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "DateIndex", attributeName = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "WorkoutTypeIndex", attributeName = "workoutType")
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

    @DynamoDBAttribute(attributeName = "distance")
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triathlon triathlon = (Triathlon) o;
        return customerId.equals(triathlon.customerId) &&
                customerName.equals(triathlon.customerName) &&
                workoutId.equals(triathlon.workoutId) &&
                date.equals(triathlon.date) &&
                workoutType.equals(triathlon.workoutType) &&
                durationInSeconds.equals(triathlon.durationInSeconds) &&
                distance.equals(triathlon.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, workoutId, date, workoutType, durationInSeconds, distance);
    }
}