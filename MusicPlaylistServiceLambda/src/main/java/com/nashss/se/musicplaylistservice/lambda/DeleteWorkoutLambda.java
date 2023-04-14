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
                                .withWorkoutType(unauthenticatedRequest.getWorkoutType())
                                .build();
                    });
                }, //this is a problem, deleteWorkoutRequest cannot be void, may need some refactoring of this lambda or the class
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteWorkoutActivity().handleRequest(request)
        );
    }




}
