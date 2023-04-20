package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.GetWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetWorkoutResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetWorkoutLambda
        extends LambdaActivityRunner<GetWorkoutRequest, GetWorkoutResult>
        implements RequestHandler<LambdaRequest<GetWorkoutRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetWorkoutRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPathAndQuery((path, query )->
                        GetWorkoutRequest.builder()
                                .withCustomerId(path.get("customerId"))
                                .withNumberOfDays(Integer.parseInt(query.get("numberOfDays")))
                                .build()),

                (request, serviceComponent) ->
                        serviceComponent.provideGetWorkoutActivity().handleRequest(request)
        );
    }
}
