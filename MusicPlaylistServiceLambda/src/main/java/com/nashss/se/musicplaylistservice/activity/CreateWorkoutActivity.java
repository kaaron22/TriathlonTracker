package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.CreateWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateWorkoutResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.musicplaylistservice.models.PlaylistModel;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import com.nashss.se.projectresources.music.playlist.servic.util.MusicPlaylistServiceUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class CreateWorkoutActivity {
    private final Logger log = LogManager.getLogger();
    private final WorkoutDao workoutDao;

    /**
     * Instantiates a new CreateWorkoutActivity object.
     *
     * @param workoutDao WorkoutDao to access the Triathlon table.
     */
    @Inject
    public CreateWorkoutActivity(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    /**
     * This method handles the incoming request by persisting a new workout
     * with the provided workout name and user ID from the request.
     * <p>
     * It then returns the newly created workout.
     * <p>
     * If the provided workout name or user ID has invalid characters, throws an
     * InvalidAttributeValueException
     *
     * @param createWorkoutRequest request object containing the playlist name and customer ID
     *                              associated with it
     * @return createPlaylistResult result object containing the API defined {@link PlaylistModel}
     */
    public CreateWorkoutResult handleRequest(final CreateWorkoutRequest createWorkoutRequest) {
        log.info("Received CreateWorkoutRequest {}", createWorkoutRequest);

        if (!MusicPlaylistServiceUtils.isValidString(createWorkoutRequest.getCustomerId())) {
            throw new InvalidAttributeValueException("Workout customer ID [" + createWorkoutRequest.getCustomerId() +
                    "] contains illegal characters");
        }

        if (createWorkoutRequest.getDate() == null || createWorkoutRequest.getWorkoutType() == null
                || createWorkoutRequest.getDate().trim().isEmpty()
                || createWorkoutRequest.getWorkoutType().trim().isEmpty()) {
            log.info("Date and WorkoutType must be provided");
            throw new InvalidAttributeValueException("Date and WorkoutType must be provided");
        }

        String workoutType = createWorkoutRequest.getWorkoutType().toUpperCase();
        if (!workoutType.equals("RUNNING") && !workoutType.equals("BIKING") && !workoutType.equals("SWIMMING")) {
            log.info("Invalid WorkoutType, Running, Biking and Swimming are the valid" +
                    " options");
            throw new InvalidAttributeValueException("Invalid WorkoutType, Running, Biking and Swimming are the valid" +
                    " options");
        }

        Triathlon newTriathlon = new Triathlon();
        newTriathlon.setWorkoutId(MusicPlaylistServiceUtils.generatePlaylistId());
        newTriathlon.setCustomerId(createWorkoutRequest.getCustomerId());
        newTriathlon.setCustomerName(createWorkoutRequest.getCustomerName());
        newTriathlon.setDate(createWorkoutRequest.getDate());
        newTriathlon.setWorkoutType(createWorkoutRequest.getWorkoutType());

        // exception/error handling to be added to make sure this parses properly
        Integer hoursToSeconds = Integer.parseInt(createWorkoutRequest.getDurationInHours()) * 3600;
        Integer minutesToSeconds = Integer.parseInt(createWorkoutRequest.getDurationInMinutes()) * 60;
        Integer seconds = Integer.parseInt(createWorkoutRequest.getDurationInSeconds());
        Integer totalTimeInSeconds = hoursToSeconds + minutesToSeconds + seconds;

        newTriathlon.setDurationInSeconds(totalTimeInSeconds);

        // exception/error handling to be added to make sure this parses properly
        Double distance = Double.parseDouble(createWorkoutRequest.getDistance());
        newTriathlon.setDistance(distance);
        workoutDao.saveTriathlon(newTriathlon);

        WorkoutModel workoutModel = new ModelConverter().toWorkoutModel(newTriathlon);
        return CreateWorkoutResult.builder()
                .withTriathlon(workoutModel)
                .build();
    }
}


