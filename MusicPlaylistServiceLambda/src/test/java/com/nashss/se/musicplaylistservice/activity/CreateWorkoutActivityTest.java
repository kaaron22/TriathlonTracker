package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreateWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateWorkoutResult;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CreateWorkoutActivityTest {
    @Mock
    private WorkoutDao workoutDao;

    private CreateWorkoutActivity createWorkoutActivity;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createWorkoutActivity = new CreateWorkoutActivity(workoutDao);
    }

    @Test
    void handleRequest_validInformation_createsAndSavesWorkout() {
        String expectedCustomerId = "test@test.com";
        String expectedDateString = "2004-12-27";
        String expectedWorkoutType = "RUNNING";
        String expectedDurationInSeconds = "0";
        String expectedDistance = "5.0";

        CreateWorkoutRequest request = CreateWorkoutRequest.builder()
                .withCustomerId(expectedCustomerId)
                .withDate(expectedDateString)
                .withWorkoutType(expectedWorkoutType)
                .withDurationInSeconds(expectedDurationInSeconds)
                .withDistance(expectedDistance)
                .build();

        //WHEN -
        CreateWorkoutResult result = createWorkoutActivity.handleRequest(request);

        //THEN
        verify(workoutDao).saveTriathlon(any(Triathlon.class));

        assertNotNull(result.getWorkoutModel().getDate());
        assertNotNull(result.getWorkoutModel().getCustomerId());
        assertEquals(expectedCustomerId, result.getWorkoutModel().getCustomerId());
        assertEquals(expectedDateString, result.getWorkoutModel().getDate());
        assertEquals(expectedWorkoutType, result.getWorkoutModel().getWorkoutType());
        assertEquals(expectedDurationInSeconds, result.getWorkoutModel().getDurationInSeconds());
        assertEquals(expectedDistance, result.getWorkoutModel().getDistance());

    }
}