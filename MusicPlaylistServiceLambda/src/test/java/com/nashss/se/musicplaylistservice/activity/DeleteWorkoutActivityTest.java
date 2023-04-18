package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.DeleteWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteWorkoutResult;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class DeleteWorkoutActivityTest {
    @Mock
    private WorkoutDao workoutDao;
    private DeleteWorkoutActivity deleteWorkoutActivity;
    @BeforeEach
    void setUp() {
        openMocks(this);
        deleteWorkoutActivity = new DeleteWorkoutActivity(workoutDao);
    }

    @Test
    public void handleRequest_validWorkoutId_returnsSuccessfully() {
        String workoutId = "12345";
        String customerId = "test@test.com";
        Triathlon workout = new Triathlon();
        String date = "2022-04-12";
        when(workoutDao.getTriathlon(workoutId)).thenReturn(workout);
        workout.setCustomerId(customerId);
        workout.setDate(date);
        workout.setDurationInSeconds(3600);
        workout.setDistance(10.0);
        workout.setWorkoutId(workoutId);
        workout.setWorkoutType("Biking");

        DeleteWorkoutRequest request = DeleteWorkoutRequest.builder()
                .withWorkoutId(workoutId)
                .withDate(date)
                .withCustomerId(customerId)
                .build();

        DeleteWorkoutResult result = deleteWorkoutActivity.handleRequest(request);

        assertNotNull(result);
        assertNotNull(result.getWorkout());
        assertEquals(workoutId, result.getWorkout().getWorkoutId());

        verify(workoutDao).getTriathlon(workoutId);
        verify(workoutDao).deleteTriathlon(workout);
    }
}