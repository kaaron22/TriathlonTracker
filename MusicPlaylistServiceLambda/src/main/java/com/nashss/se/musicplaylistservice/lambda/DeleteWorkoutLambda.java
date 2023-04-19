package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.DeleteWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteWorkoutResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteWorkoutLambda extends LambdaActivityRunner<DeleteWorkoutRequest, DeleteWorkoutResult>
        implements RequestHandler<AuthenticatedLambdaRequest<DeleteWorkoutRequest>, LambdaResponse> {
    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteWorkoutRequest> input, Context context) {
        log.info("Handling request to delete workout");
        return super.runActivity(
                () -> input.fromPath(path -> {
                    String workoutId = path.get("workoutId");
                    return input.fromUserClaims(claims -> {
                        String customerId = claims.get("email");

                        return DeleteWorkoutRequest.builder()
                                .withCustomerId(customerId)
                                .withWorkoutId(workoutId)
                                .build();
                    });
                }),
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteWorkoutActivity().handleRequest(request)
        );
    }
}







