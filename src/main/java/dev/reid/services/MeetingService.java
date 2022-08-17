package dev.reid.services;

import dev.reid.entity.Meeting;

import java.util.List;

public interface MeetingService {
    Meeting registerMeeting(Meeting meeting);

    List<Meeting> viewMeetings();

}
