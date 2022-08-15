package dev.reid.daos;

import dev.reid.entity.Meeting;

import java.util.List;

public interface MeetingDAO {
    Meeting createMeeting(Meeting meeting);

    Meeting getMeetingByID(int id);

    Meeting updateMeetingLocation(int id);

    Meeting updateMeetingDate(int id);

    List<Meeting> getListOfMeetings();

    boolean deleteMeetingByID(int id);
}
