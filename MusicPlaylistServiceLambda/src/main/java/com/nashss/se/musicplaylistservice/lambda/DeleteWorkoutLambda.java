package com.nashss.se.musicplaylistservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.requests.DeleteWorkoutRequest;
import com.nashss.se.musicplaylistservice.activity.results.DeleteWorkoutResult;

public class DeleteWorkoutLambda extends LambdaActivityRunner<DeleteWorkoutRequest, DeleteWorkoutResult>
        implements RequestHandler<AuthenticatedLambdaRequest<DeleteWorkoutRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteWorkoutRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    DeleteWorkoutRequest unauthenticatedRequest = input.fromBody(DeleteWorkoutRequest.class);
                    return input.fromUserClaims(claims ->
                    {
                        assert unauthenticatedRequest != null;
                        return DeleteWorkoutRequest.builder()
                                .withCustomerId(claims.get("email"))
                                .withDate(unauthenticatedRequest.getDate())
                                .withWorkoutId(unauthenticatedRequest.getWorkoutId())
                                .build();
                    });
                },
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteWorkoutActivity().handleRequest(request)
        );
    }




}
