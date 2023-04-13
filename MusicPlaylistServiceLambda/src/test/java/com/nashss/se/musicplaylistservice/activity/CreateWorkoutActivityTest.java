package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreateWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateWorkoutResult;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.utils.WorkoutType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

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
        LocalDateTime expectedDate = LocalDateTime.now();
        WorkoutType expectedWorkoutType = WorkoutType.RUNNING;
        Integer expectedDurationInHours = 1;
        Integer expectedDurationInMinutes = 30;
        Integer expectedDurationInSeconds = 0;
        Double expectedDistance = 5.0;

        CreateWorkoutRequest request = CreateWorkoutRequest.builder()
                .withCustomerId(expectedCustomerId)
                .withDate(expectedDate.toString())
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

    }
}