package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.DeleteWorkoutRequest;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
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

    public void handleRequest(final DeleteWorkoutRequest deleteWorkoutRequest) {
        log.info("Received DeleteWorkoutRequest {}", deleteWorkoutRequest);

        if (!MusicPlaylistServiceUtils.isValidString(deleteWorkoutRequest.getCustomerId())) {
            throw new InvalidAttributeValueException("Workout customer ID [" + deleteWorkoutRequest.getCustomerId() +
                    "] contains illegal characters");
        }

        workoutDao.deleteTriathlon(workoutDao.getTriathlon(deleteWorkoutRequest.getCustomerId()));
    }

}
