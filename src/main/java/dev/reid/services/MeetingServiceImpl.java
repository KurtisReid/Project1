package dev.reid.services;

import dev.reid.daos.MeetingDAO;
import dev.reid.daos.MeetingDAOPostgres;
import dev.reid.entity.Meeting;

public class MeetingServiceImpl implements MeetingService{
    private MeetingDAO meetingDAO = new MeetingDAOPostgres();
    @Override
    public Meeting registerMeeting(Meeting meeting) {
        System.out.println("MeetingServiceImpl registerMeeting");
        System.out.println(meeting);
        Meeting savedMeeting = this.meetingDAO.createMeeting(meeting);
        return savedMeeting;
    }
}
