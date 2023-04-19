package com.nashss.se.musicplaylistservice.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class WorkoutDao {
    private final DynamoDBMapper dynamoDbMapper;
    private final MetricsPublisher metricsPublisher;

    /**
     * Instantiates a WorkoutDao object.
     *
     * @param dynamoDbMapper   the {@link DynamoDBMapper} used to interact with the triathlon table
     * @param metricsPublisher the {@link MetricsPublisher} used to record metrics.
     */
    @Inject
    public WorkoutDao(DynamoDBMapper dynamoDbMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDbMapper = dynamoDbMapper;
        this.metricsPublisher = metricsPublisher;
    }

    /**
     * Returns the  Workout corresponding to the specified id.
     *
     * @param workoutId the Triathlon ID
     * @return the stored Workout, or null if none was found.
     */
    public Triathlon getTriathlon(String workoutId) {
        return this.dynamoDbMapper.load(Triathlon.class, workoutId);
    }
    public List <Triathlon> getSevenDayHistory (String customerId) {
        LocalDate endLocal = LocalDate.now();
        LocalDate startLocal = LocalDate.now().minusDays(6);


        Map<String, AttributeValue> valueMap = new HashMap<>();
        //valueMap.put(":startDate", new AttributeValue().withS(startLocal.toString()));
      //  valueMap.put(":endDate", new AttributeValue().withS(endLocal.toString()));
        valueMap.put(":customerId", new AttributeValue().withS(customerId));
        DynamoDBQueryExpression<Triathlon> queryExpression = new DynamoDBQueryExpression<Triathlon>()
                .withIndexName("CustomerIdIndex")

              //  .withExpressionAttributeNames(Map.of("#TriathlonDate", "date"))
                //.withProjectionExpression("#TriathlonDate")
                .withConsistentRead(false)
                .withKeyConditionExpression("customerId = :customerId" )
                .withExpressionAttributeValues(valueMap);

        return dynamoDbMapper.query(Triathlon.class, queryExpression);
    }

    /**
     * Saves (creates or updates) the given playlist.
     *
     * @param workout The workout to save
     * @return The Triathlon object that was saved
     */
    public Triathlon saveTriathlon(Triathlon workout) {
        this.dynamoDbMapper.save(workout);
        return workout;
    }
}