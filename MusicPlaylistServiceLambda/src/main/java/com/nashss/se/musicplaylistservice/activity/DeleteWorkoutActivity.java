package com.nashss.se.musicplaylistservice.activity;

import com.amazonaws.services.cloudwatch.model.ResourceNotFoundException;
import com.nashss.se.musicplaylistservice.activity.requests.DeleteWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteWorkoutResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.exceptions.DeleteWorkoutException;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;
import com.nashss.se.projectresources.music.playlist.servic.util.MusicPlaylistServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteWorkoutActivity {
    private final Logger log = LogManager.getLogger();
    private final WorkoutDao workoutDao;

    @Inject
    public DeleteWorkoutActivity(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    public DeleteWorkoutResult handleRequest(final DeleteWorkoutRequest deleteWorkoutRequest) {
        log.info("Received DeleteWorkoutRequest {}", deleteWorkoutRequest);
//        String workoutId = deleteWorkoutRequest.getWorkoutId();
        Triathlon workout = workoutDao.getTriathlon(deleteWorkoutRequest.getWorkoutId());

        if (workout == null) {
            throw new DeleteWorkoutException("Workout with ID " + deleteWorkoutRequest.getWorkoutId() + "not found.");
        }

        try {
            workoutDao.deleteTriathlon(workout);
        } catch (DeleteWorkoutException e) {
            log.error("Error deleting workout: {}", e.getMessage());
            System.out.println(e.getMessage());
        }

        //Model conversion
//        WorkoutModel workoutModel =  new ModelConverter().toWorkoutModel(workout);

        return DeleteWorkoutResult.builder()
                .withWorkoutId(deleteWorkoutRequest.getWorkoutId())
                .build();
    }

}
