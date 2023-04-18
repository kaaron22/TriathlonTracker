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
                () -> {
//                    DeleteWorkoutRequest unauthenticatedRequest = input.fromBody(DeleteWorkoutRequest.class);
//                    log.info("Unauthenticated request: {}", unauthenticatedRequest);
//                    String workoutId = input.getPathParameters().get("workoutId");
                    String path = input.getPathParameters().get("workoutId");
                    return input.fromUserClaims(claims ->
                            DeleteWorkoutRequest.builder()
                                    .withWorkoutId(path)
                                    .withCustomerId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteWorkoutActivity().handleRequest(request)
        );
    }




}
