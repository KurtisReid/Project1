package dev.reid.daoTests.daoTests;

import dev.reid.daos.MeetingDAO;
import dev.reid.daos.MeetingDAOPostgres;
import dev.reid.entity.Meeting;
import dev.reid.utils.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MeetingDAOTests {
/*
    @BeforeAll
    static void setup()
    {
        try(Connection conn = ConnectionUtil.createConnection())
        {
            String sql = "create table meeting(\n" +
                    "\tmeeting_id serial primary key not null,\n" +
                    "\tmeeting_location varchar(40),\n" +
                    "\tmeeting_date int,\n" +
                    "\tsummary varchar(200)\n" +
                    ");";
            Statement statement = conn.createStatement();
            statement.execute(sql);

            String sql2 = "insert into meeting values(-1,'city hall',0, 'no meeting assigned')";
            Statement statement2 = conn.createStatement();
            statement2.execute(sql2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    static MeetingDAO meetingDAO = new MeetingDAOPostgres();
    @Test
    void create_meeting_test()
    {
        Meeting meeting = new Meeting(0, "city Hall", 1660678457, "hello");
        Meeting savedMeeting = meetingDAO.createMeeting(meeting);
        System.out.println("hello: " + meetingDAO.getListOfMeetings());
        int size = meetingDAO.getListOfMeetings().size();

        Assertions.assertEquals(size-1, savedMeeting.getId());

    }

    @Test
    void get_List_of_meeting_test()
    {
        List<Meeting> meetingList = meetingDAO.getListOfMeetings();
        int size = meetingDAO.getListOfMeetings().size();
        Meeting meeting = new Meeting(1, "city Hall", 1660678457, "the empire walked through again");
        Meeting savedMeeting = meetingDAO.createMeeting(meeting);
        System.out.println("hello: " + meetingDAO.getListOfMeetings());


        Assertions.assertEquals(size, savedMeeting.getId());

        //Meeting savedMeeting = meetingDAO.createMeeting(meeting);


    }
}
