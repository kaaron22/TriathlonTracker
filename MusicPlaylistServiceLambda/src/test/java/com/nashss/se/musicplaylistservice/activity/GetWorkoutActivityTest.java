package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.GetWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetWorkoutResult;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GetWorkoutActivityTest {
    @Mock
    private WorkoutDao workoutDao;
    private GetWorkoutActivity getWorkoutActivity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getWorkoutActivity = new GetWorkoutActivity(workoutDao);
    }

    @Test
    void handleRequest_validInformation_retrievesWorkouts() {
        String customerId = "test@test.com";
        String numberOfDays = "7";
        List<Triathlon> mockList = new ArrayList<>();

        when(workoutDao.getSevenDayHistory(customerId, Integer.parseInt(numberOfDays))).thenReturn(mockList);

        GetWorkoutRequest request = GetWorkoutRequest.builder()
                .withCustomerId(customerId)
                .withNumberOfDays(numberOfDays)
                .build();

        GetWorkoutResult result = getWorkoutActivity.handleRequest(request);

        verify(workoutDao).getSevenDayHistory(customerId, Integer.parseInt(numberOfDays));
        assertNotNull(result.getWorkoutModels());
        assertNull(result.getErrorMessage());
    }

    @Test
    void handleRequest_invalidNumberOfDays_returnsErrorMessage() {
        String customerId = "test@test.com";
        String numberOfDays = "invalid_input";

        GetWorkoutRequest request = GetWorkoutRequest.builder()
                .withCustomerId(customerId)
                .withNumberOfDays(numberOfDays)
                .build();

        GetWorkoutResult result = getWorkoutActivity.handleRequest(request);

        assertTrue(result.getWorkoutModels().isEmpty());
        assertNotNull(result.getErrorMessage());
        assertEquals("Invalid input for numberOfDays: " + numberOfDays, result.getErrorMessage());
    }
}