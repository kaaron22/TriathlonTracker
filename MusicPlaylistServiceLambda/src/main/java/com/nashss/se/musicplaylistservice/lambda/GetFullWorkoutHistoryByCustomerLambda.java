package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.nashss.se.musicplaylistservice.activity.requests.GetFullWorkoutHistoryByCustomerRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetFullWorkoutHistoryByCustomerResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetFullWorkoutHistoryByCustomerLambda
        extends LambdaActivityRunner<GetFullWorkoutHistoryByCustomerRequest, GetFullWorkoutHistoryByCustomerResult>
        implements RequestHandler<AuthenticatedLambdaRequest<GetFullWorkoutHistoryByCustomerRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<GetFullWorkoutHistoryByCustomerRequest> input,
                                        Context context) {
        log.info("FullHistoryHandleRequest");
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetFullWorkoutHistoryByCustomerRequest.builder()
                                .withCustomerId(path.get("customerId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetFullWorkoutHistoryByCustomerActivity().handleRequest(request)
        );
    }
}
