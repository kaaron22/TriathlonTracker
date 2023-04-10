package com.nashss.se.musicplaylistservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "meal_log")
public class MealLogModel {
    private String customerId;
    private String timestamp;
    private String name;
    private String type;
    private Double calories;
    private Double carbs;
    private Double protein;
    private Double fat;

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

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @DynamoDBAttribute(attributeName = "calories")
    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @DynamoDBAttribute(attributeName = "carbs")
    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    @DynamoDBAttribute(attributeName = "protein")
    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    @DynamoDBAttribute(attributeName = "fat")
    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealLogModel that = (MealLogModel) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(timestamp, that.timestamp) && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(calories, that.calories) && Objects.equals(carbs, that.carbs) && Objects.equals(protein, that.protein) && Objects.equals(fat, that.fat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, timestamp, name, type, calories, carbs, protein, fat);
    }
}
