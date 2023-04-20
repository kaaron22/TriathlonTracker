package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.GetWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetWorkoutResult;
import com.nashss.se.musicplaylistservice.converters.ModelConverter;
import com.nashss.se.musicplaylistservice.dynamodb.WorkoutDao;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;


public class GetWorkoutActivity {
    private final Logger log = LogManager.getLogger();
    private final WorkoutDao workoutDao;

    /**
     * Instantiates a new GetPlaylistSongsActivity object.
     *
     * @param workoutDao WorkoutDao to access the Triathlon table.
     */
    @Inject
    public GetWorkoutActivity(WorkoutDao workoutDao) {
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
    public GetWorkoutResult handleRequest(final GetWorkoutRequest getWorkoutRequest) {
        log.info("Received GetWorkoutRequest {}", getWorkoutRequest);

        //String songOrder = computeSongOrder(getPlaylistSongsRequest.getOrder());

        List<Triathlon> workouts = workoutDao.getSevenDayHistory(getWorkoutRequest.getCustomerId(), getWorkoutRequest.getNumberOfDays());

        System.out.println("Line 49");
        List<WorkoutModel> workoutModels = new ModelConverter().toWorkoutModels(workouts);
        System.out.println("line 51 :" + workoutModels);
        log.info("Received GetWorkoutRequest {}", workoutModels.toString());
        return GetWorkoutResult.builder()
                .withWorkoutList(workoutModels)
                .build();
    }


}

