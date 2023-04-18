package com.nashss.se.musicplaylistservice.converters;

import com.nashss.se.musicplaylistservice.dynamodb.models.AlbumTrack;
import com.nashss.se.musicplaylistservice.dynamodb.models.Playlist;
import com.nashss.se.musicplaylistservice.dynamodb.models.Triathlon;
import com.nashss.se.musicplaylistservice.models.PlaylistModel;
import com.nashss.se.musicplaylistservice.models.SongModel;
import com.nashss.se.musicplaylistservice.models.WorkoutModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts between Data and API models.
 */
public class ModelConverter {

    public WorkoutModel toWorkoutModel(Triathlon workout) {

        Integer totalTimeInSeconds = workout.getDurationInSeconds();

        if (!(null == totalTimeInSeconds)) {
            WorkoutDuration durationInHoursMinutesSeconds = convertTotalSecondsToHoursMinutesSeconds(totalTimeInSeconds);

            return WorkoutModel.builder()
                    .withWorkoutId(workout.getWorkoutId())
                    .withCustomerId(workout.getCustomerId())
                    .withCustomerName(workout.getCustomerName())
                    .withDate(workout.getDate())
                    .withWorkoutType(workout.getWorkoutType())
                    .withDurationInHours(durationInHoursMinutesSeconds.getHours())
                    .withDurationInMinutes(durationInHoursMinutesSeconds.getMinutes())
                    .withDurationInSeconds(durationInHoursMinutesSeconds.getSeconds())
                    .withDistance(String.valueOf(workout.getDistance()))
                    .build();
        } else {
            return WorkoutModel.builder()
                    .withWorkoutId(workout.getWorkoutId())
                    .withCustomerId(workout.getCustomerId())
                    .withCustomerName(workout.getCustomerName())
                    .withDate(workout.getDate())
                    .withWorkoutType(workout.getWorkoutType())
                    .withDurationInHours(null)
                    .withDurationInMinutes(null)
                    .withDurationInSeconds(null)
                    .withDistance(String.valueOf(workout.getDistance()))
                    .build();
        }
    }

    public List<WorkoutModel> toWorkoutModels(List<Triathlon> triathlonList) {

        List<WorkoutModel> workoutModels = new ArrayList<>();

        for(Triathlon triathlon : triathlonList) {
            workoutModels.add(toWorkoutModel(triathlon));
        }

        return workoutModels;
    }

    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     *
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        List<String> tags = null;
        if (playlist.getTags() != null) {
            tags = new ArrayList<>(playlist.getTags());
        }

        return PlaylistModel.builder()
                .withId(playlist.getId())
                .withName(playlist.getName())
                .withCustomerId(playlist.getCustomerId())
                .withCustomerName(playlist.getCustomerName())
                .withSongCount(playlist.getSongCount())
                .withTags(tags)
                .build();
    }

    /**
     * Converts a provided AlbumTrack into a SongModel representation.
     *
     * @param albumTrack the AlbumTrack to convert to SongModel
     * @return the converted SongModel with fields mapped from albumTrack
     */
    public SongModel toSongModel(AlbumTrack albumTrack) {
        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withTrackNumber(albumTrack.getTrackNumber())
                .withAlbum(albumTrack.getAlbumName())
                .withTitle(albumTrack.getSongTitle())
                .build();
    }

    /**
     * Converts a list of AlbumTracks to a list of SongModels.
     *
     * @param albumTracks The AlbumTracks to convert to SongModels
     * @return The converted list of SongModels
     */
    public List<SongModel> toSongModelList(List<AlbumTrack> albumTracks) {
        List<SongModel> songModels = new ArrayList<>();

        for (AlbumTrack albumTrack : albumTracks) {
            songModels.add(toSongModel(albumTrack));
        }

        return songModels;
    }

    /**
     * Converts a list of Playlists to a list of PlaylistModels.
     *
     * @param playlists The Playlists to convert to PlaylistModels
     * @return The converted list of PlaylistModels
     */
    public List<PlaylistModel> toPlaylistModelList(List<Playlist> playlists) {
        List<PlaylistModel> playlistModels = new ArrayList<>();

        for (Playlist playlist : playlists) {
            playlistModels.add(toPlaylistModel(playlist));
        }

        return playlistModels;
    }

    private WorkoutDuration convertTotalSecondsToHoursMinutesSeconds(Integer totalWorkoutDurationInASeconds) {
        Integer totalSecondsToConvertToHoursMinutesSeconds = totalWorkoutDurationInASeconds;
        Integer seconds = totalSecondsToConvertToHoursMinutesSeconds % 60;
        String secondsToStringValue = String.valueOf(seconds);

        Integer remainingSecondsToConvertToHoursMinutes = totalSecondsToConvertToHoursMinutesSeconds - seconds;
        Integer remainingMinutesToConvertToHoursMinutes = remainingSecondsToConvertToHoursMinutes / 60;
        Integer minutes = remainingMinutesToConvertToHoursMinutes % 60;
        String minutesToStringValue = String.valueOf(minutes);

        Integer remainingMinutesToConvertToHours = remainingMinutesToConvertToHoursMinutes - minutes;
        Integer hours = remainingMinutesToConvertToHours / 60;
        String hoursToStringValue = String.valueOf(hours);

        return new WorkoutDuration(hoursToStringValue, minutesToStringValue, secondsToStringValue);
    }
}
