package com.nashss.se.musicplaylistservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "water_log")
public class WaterLogModel {

    private String customerId;
    private String timestamp;
    private String customerName;
    private Double ounces;

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

    @DynamoDBAttribute(attributeName = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @DynamoDBAttribute(attributeName = "ounces")
    public Double getOunces() {
        return ounces;
    }

    public void setOunces(Double ounces) {
        this.ounces = ounces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterLogModel that = (WaterLogModel) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(timestamp, that.timestamp) && Objects.equals(customerName, that.customerName) && Objects.equals(ounces, that.ounces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, timestamp, customerName, ounces);
    }
}
