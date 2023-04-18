package com.nashss.se.musicplaylistservice.dynamodb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.Delete;
import com.amazonaws.services.lambda.runtime.events.models.dynamodb.AttributeValue;
import com.nashss.se.musicplaylistservice.activity.requests.DeleteWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteWorkoutResult;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.exceptions.DeleteWorkoutException;
import com.nashss.se.musicplaylistservice.metrics.MetricsPublisher;

import javax.inject.Inject;
import javax.inject.Singleton;

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
    public void deleteTriathlon(Triathlon workout) {
        try {
            this.dynamoDbMapper.delete(workout);
        } catch (AmazonClientException e) {
            throw new DeleteWorkoutException("Could not delete workout with ID" + workout.getWorkoutId());
        }
    }
}
