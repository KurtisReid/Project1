package dev.reid.daoTests.daoTests;

import dev.reid.daos.ComplaintDAO;
import dev.reid.daos.ComplaintDAOPostgres;
import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;
import dev.reid.utils.ConnectionUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CompliantDAOTests {

    static ComplaintDAO complaintDAO = new ComplaintDAOPostgres();

    @BeforeAll
    static void setup()
    {
        try(Connection conn = ConnectionUtil.createConnection())
        {
            String sql = "create table complaint(\n" +
                    "\tcomplaint_id serial primary key,\n" +
                    "\tcomplaint_desc varchar(40),\n" +
                    "\tpriority varchar(40) not null,\n" +
                    "\tmeeting_id int references meeting(meeting_id) default -1\n" +
                    "\n" +
                    ");";
            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void create_complaint_Test()
    {
        Complaint complaint = new Complaint(1, "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2, "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3, "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        //List<Complaint> compaintList = complaintDAO.getListOfComplaints();
        int size = complaintDAO.getListOfComplaints().size();
        System.out.println(complaintDAO.getListOfComplaints());

        Assertions.assertEquals(size, savedComplaint3.getComplaintID());

    }
    @Test
    void get_Complaint_By_ID_Test()
    {
        Complaint complaint = new Complaint(1, "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2, "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3, "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        Complaint savedComplaint4 = complaintDAO.getComplaintByID(1);

        Assertions.assertEquals(1, savedComplaint4.getComplaintID());
    }

    @Test
    void update_Complaint_Priority_Test()
    {
        Complaint complaint = new Complaint(1, "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2, "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3, "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        Complaint updatedComplaint = complaintDAO.updateComplaintPriority(1, Priority.HIGH);
        Complaint updatedComplaint2 = complaintDAO.updateComplaintPriority(2, Priority.LOW);
        Complaint updatedComplaint3 = complaintDAO.updateComplaintPriority(3, Priority.IGNORED);

        Priority p1 = complaintDAO.getComplaintByID(1).getPriority();

        List<Complaint> compaintList2 = complaintDAO.getListOfComplaints();
        System.out.println(compaintList2);

        Assertions.assertEquals(Priority.HIGH, updatedComplaint.getPriority());
        Assertions.assertEquals(Priority.LOW, complaintDAO.getComplaintByID(2).getPriority());
        Assertions.assertEquals(Priority.IGNORED, complaintDAO.getComplaintByID(3).getPriority());
    }

    @Test
    void get_List_Of_Complaints_Test()
    {
        List<Complaint> compaintList = complaintDAO.getListOfComplaints();

        Complaint complaint = new Complaint(1, "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3, "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        List<Complaint> compaintList2 = complaintDAO.getListOfComplaints();
        System.out.println(compaintList2);

        Assertions.assertEquals(compaintList.size()+3,compaintList2.size());
    }

    @Test
    void update_Complaint_Meeting_Test()
    {
        Complaint complaint = new Complaint(1, "thg", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2, "Empire stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3, "Bad people are here", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        Complaint updatedComplaint = complaintDAO.updateComplaintMeeting(1, 2, Priority.PENDING);
        Complaint updatedComplaint2 = complaintDAO.updateComplaintMeeting(2, 2, Priority.IGNORED);
        Complaint updatedComplaint3 = complaintDAO.updateComplaintMeeting(3, 2, Priority.LOW);
        Assertions.assertEquals(updatedComplaint.getPriority(), Priority.PENDING);
        Assertions.assertEquals(Priority.IGNORED, updatedComplaint2.getPriority());
        Assertions.assertEquals(Priority.LOW, updatedComplaint3.getPriority());
        System.out.println(updatedComplaint);
        System.out.println(updatedComplaint2);
        System.out.println(updatedComplaint3);

        Assertions.assertEquals(updatedComplaint.getMeetingId(), 2);

    }
    @Test
    void delete_Complaint_By_ID_Test()
    {
        Complaint complaint = new Complaint(1, "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2, "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3, "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        boolean result = complaintDAO.deleteComplaintByID(1);

        Assertions.assertEquals(true, result);

    }
/*
    @AfterAll
    static void teardown()
    {
        try(Connection connection = ConnectionUtil.createConnection())
        {
            String sql = "drop table complaint";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

}
