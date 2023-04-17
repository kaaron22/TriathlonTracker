package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreateWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateWorkoutResult;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

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
        String expectedCustomerName = "test test";
        LocalDate expectedDateString = "2004-12-27";
        String expectedWorkoutType = "RUNNING";
        String expectedDurationInHours = "2";
        String expectedDurationInMinutes = "30";
        String expectedDurationInSeconds = "15";
        String expectedDistance = "5.0";

        CreateWorkoutRequest request = CreateWorkoutRequest.builder()
                .withCustomerId(expectedCustomerId)
                .withCustomerName(expectedCustomerName)
                .withDate(expectedDateString)
                .withWorkoutType(expectedWorkoutType)
                .withDurationInHours(expectedDurationInHours)
                .withDurationInMinutes(expectedDurationInMinutes)
                .withDurationInSeconds(expectedDurationInSeconds)
                .withDistance(expectedDistance)
                .build();

        //WHEN -
        CreateWorkoutResult result = createWorkoutActivity.handleRequest(request);

        //THEN
        verify(workoutDao).saveTriathlon(any(Triathlon.class));

        assertNotNull(result.getWorkoutModel().getDate());
        assertNotNull(result.getWorkoutModel().getCustomerId());
        assertNotNull(result.getWorkoutModel().getWorkoutId());
        assertEquals(expectedCustomerId, result.getWorkoutModel().getCustomerId());
        assertEquals(expectedCustomerName, result.getWorkoutModel().getCustomerName());
        assertEquals(expectedDateString, result.getWorkoutModel().getDate());
        assertEquals(expectedWorkoutType, result.getWorkoutModel().getWorkoutType());
        assertEquals(expectedDurationInHours, result.getWorkoutModel().getDurationInHours());
        assertEquals(expectedDurationInMinutes, result.getWorkoutModel().getDurationInMinutes());
        assertEquals(expectedDurationInSeconds, result.getWorkoutModel().getDurationInSeconds());
        assertEquals(expectedDistance, result.getWorkoutModel().getDistance());

    }
}