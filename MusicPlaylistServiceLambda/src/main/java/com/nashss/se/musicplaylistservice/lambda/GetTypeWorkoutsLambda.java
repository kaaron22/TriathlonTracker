package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.GetTypeWorkoutsRequest;
import com.nashss.se.musicplaylistservice.activity.requests.GetWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetTypeWorkoutsResult;
import com.nashss.se.musicplaylistservice.activity.results.GetWorkoutResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetTypeWorkoutsLambda
        extends LambdaActivityRunner<GetTypeWorkoutsRequest, GetTypeWorkoutsResult>
        implements RequestHandler<LambdaRequest<GetTypeWorkoutsRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetTypeWorkoutsRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPathAndQuery((path, query)->
                        GetTypeWorkoutsRequest.builder()
                                .withCustomerId(path.get("customerId"))
                                .withNumberOfDays(query.get("numberOfDays"))
                                .build()),

                (request, serviceComponent) ->
                        serviceComponent.provideGetTypeWorkoutsActivity().handleRequest(request)
        );
    }
}
