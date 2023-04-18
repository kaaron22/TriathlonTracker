package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.GetWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetWorkoutResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetWorkoutLambda
        extends LambdaActivityRunner<GetWorkoutRequest, GetWorkoutResult>
        implements RequestHandler<AuthenticatedLambdaRequest<GetWorkoutRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<GetWorkoutRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    GetWorkoutRequest unauthenticatedRequest = input.fromBody(GetWorkoutRequest.class);
                    return input.fromUserClaims(claims ->
                            GetWorkoutRequest.builder()
                                    .withCustomerId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideGetWorkoutActivity().handleRequest(request)
        );
    }
}
