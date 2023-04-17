package com.nashss.se.musicplaylistservice.lambda;

import com.nashss.se.musicplaylistservice.activity.requests.CreateWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.CreateWorkoutResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateWorkoutLambda
        extends LambdaActivityRunner<CreateWorkoutRequest, CreateWorkoutResult>
        implements RequestHandler<AuthenticatedLambdaRequest<CreateWorkoutRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateWorkoutRequest> input, Context context) {
        return super.runActivity(
            () -> {
                CreateWorkoutRequest unauthenticatedRequest = input.fromBody(CreateWorkoutRequest.class);
                return input.fromUserClaims(claims ->
                            CreateWorkoutRequest.builder()
                                    .withDate(unauthenticatedRequest.getDate())
                                    .withWorkoutType(unauthenticatedRequest.getWorkoutType())
                                    .withDurationInHours(unauthenticatedRequest.getDurationInHours())
                                    .withDurationInMinutes(unauthenticatedRequest.getDurationInMinutes())
                                    .withDurationInSeconds(unauthenticatedRequest.getDurationInSeconds())
                                    .withDistance(unauthenticatedRequest.getDistance())
                                    .withCustomerId(claims.get("email"))
                                    .withCustomerName(claims.get("name"))
                                    .build());
            },
            (request, serviceComponent) ->
                        serviceComponent.provideCreateWorkoutActivity().handleRequest(request)
        );
    }
}