package com.nashss.se.musicplaylistservice.converters;

public class WorkoutDuration {

    private final String hours;
    private final String minutes;
    private final String seconds;

    public WorkoutDuration(final String hours, final String minutes, final String seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getHours() {
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }
}
