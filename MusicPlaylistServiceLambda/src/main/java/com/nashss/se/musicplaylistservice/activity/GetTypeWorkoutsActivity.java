package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest;
import com.nashss.se.musicplaylistservice.activity.requests.GetWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult;
import com.nashss.se.musicplaylistservice.activity.results.GetWorkoutResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class GetTypeWorkoutsActivity {
    private final Logger log = LogManager.getLogger();
    private final WorkoutDao workoutDao;

    /**
     * Instantiates a new GetPlaylistSongsActivity object.
     *
     * @param workoutDao WorkoutDao to access the Triathlon table.
     */
    @Inject
    public GetTypeWorkoutsActivity(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    /**
     * This method handles the incoming request by retrieving the playlist from the database.
     * <p>
     * It then returns the playlist's song list.
     * <p>
     * If the playlist does not exist, this should throw a PlaylistNotFoundException.
     *
     * @param getWorkoutRequest request object containing the customer ID
     * @return getWorkoutResult result object containing the customer's list of API defined {@link WorkoutModel}s
     */
    public GetTypeWorkoutsResult handleRequest(final GetTypeWorkoutsRequest getWorkoutRequest) {
        log.info("Received GetWorkoutRequest {}", getWorkoutRequest);

        int numberOfDays;
        try {
            numberOfDays = Integer.parseInt(getWorkoutRequest.getNumberOfDays());
        } catch (NumberFormatException e) {
            log.info("Invalid input for numberOfDays: " + getWorkoutRequest.getNumberOfDays());
            return GetTypeWorkoutsResult.builder()
                    .withErrorMessage("Invalid input for numberOfDays: " + getWorkoutRequest.getNumberOfDays())
                    .build();
        }

        Map<String, Integer> typeCount = workoutDao.getWorkoutTypeNum(getWorkoutRequest.getCustomerId(), numberOfDays);


        log.info("workoutModels converted");
        return GetTypeWorkoutsResult.builder()
                .withRunCount(typeCount.get("run"))
                .withSwimCount(typeCount.get("swim"))
                .withBikeCount(typeCount.get("bike"))
                .build();
    }
}