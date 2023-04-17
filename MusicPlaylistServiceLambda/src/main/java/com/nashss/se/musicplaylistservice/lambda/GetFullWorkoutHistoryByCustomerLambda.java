package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.nashss.se.musicplaylistservice.activity.requests.GetFullWorkoutHistoryByCustomerRequest;
import com.nashss.se.musicplaylistservice.activity.results.GetFullWorkoutHistoryByCustomerResult;

public class GetFullWorkoutHistoryByCustomerLambda
        extends LambdaActivityRunner<GetFullWorkoutHistoryByCustomerRequest, GetFullWorkoutHistoryByCustomerResult>
        implements RequestHandler<AuthenticatedLambdaRequest<GetFullWorkoutHistoryByCustomerRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<GetFullWorkoutHistoryByCustomerRequest> input,
                                        Context context) {
        return super.runActivity(
                () -> {
                    GetFullWorkoutHistoryByCustomerRequest unauthenticatedRequest =
                            input.fromBody(GetFullWorkoutHistoryByCustomerRequest.class);
                    return input.fromUserClaims(claims ->
                            GetFullWorkoutHistoryByCustomerRequest.builder()
                                    .withCustomerId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) ->
                            serviceComponent.provideGetFullWorkoutHistoryByCustomerLambda().handleRequest(request)
        );
    }
}
