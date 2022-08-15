package dev.reid.daos;

import dev.reid.entity.Meeting;

import java.util.List;

public class MeetingDAOPostgres implements MeetingDAO{

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return null;
    }

    @Override
    public Meeting getMeetingByID(int id) {
        return null;
    }

    @Override
    public Meeting updateMeetingLocation(int id) {
        return null;
    }

    @Override
    public Meeting updateMeetingDate(int id) {
        return null;
    }

    @Override
    public List<Meeting> getListOfMeetings() {
        return null;
    }

    @Override
    public boolean deleteMeetingByID(int id) {
        return false;
    }
}
