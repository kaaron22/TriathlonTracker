package com.nashss.se.musicplaylistservice.activity;

import com.nashss.se.musicplaylistservice.activity.requests.GetFullWorkoutHistoryByCustomerRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetFullWorkoutHistoryByCustomerResult;
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
import java.util.List;

public class GetFullWorkoutHistoryByCustomerActivity {

    private final Logger log = LogManager.getLogger();
    private final WorkoutDao workoutDao;

    /**
     * Instantiates a new GetFullWorkoutHistoryByCustomerActivity object
     *
     * @param workoutDao WorkoutDao to access the Triathlon table
     */
    @Inject
    public GetFullWorkoutHistoryByCustomerActivity(WorkoutDao workoutDao) { this.workoutDao = workoutDao; }

    /**
     * This method handles the incoming request by querying a list of all
     * workouts for the specified customerId.
     * <p>
     * If the provided customer ID has invalid characters, throws an
     * InvalidAttributeValueException
     *
     * @param getFullWorkoutHistoryByCustomerRequest request object containing the playlist name and customer ID
     *                              associated with it
     * @return getFullWorkoutHistoryByCustomerResult result object containing the API defined {@link PlaylistModel}
     */
    public GetFullWorkoutHistoryByCustomerResult handleRequest(final GetFullWorkoutHistoryByCustomerRequest
                                                                       getFullWorkoutHistoryByCustomerRequest) {
        log.info("Received GetFullWorkoutHistoryByCustomerRequest {}", getFullWorkoutHistoryByCustomerRequest);
        String customerId = getFullWorkoutHistoryByCustomerRequest.getCustomerId();
        List<Triathlon> triathlonList = workoutDao.getAllTriathlonRecordsForCustomer(customerId);
        List<WorkoutModel> workoutModels = new ModelConverter().toWorkoutModels(triathlonList);

        return GetFullWorkoutHistoryByCustomerResult.builder()
                .withTriathlonList(workoutModels)
                .build();
    }

}
