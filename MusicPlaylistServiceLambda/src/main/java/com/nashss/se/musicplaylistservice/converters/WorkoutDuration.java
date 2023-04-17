package com.nashss.se.musicplaylistservice.converters;

public class WorkoutDuration {

    private final Integer hours;
    private final Integer minutes;
    private final Integer seconds;

    public WorkoutDuration(final Integer hours, final Integer minutes, final Integer seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }
}
