package dev.reid.daoTests.daoTests;

import dev.reid.daos.ComplaintDAO;
import dev.reid.daos.ComplaintDAOPostgres;
import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;
import dev.reid.utils.ConnectionUtil;
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
                    "\tid serial primary key not null,\n" +
                    "\tconstituent_submission_id varchar(40),\n" +
                    "\tcomplaint_desc varchar(40),\n" +
                    "\tpriority varchar(40) not null,\n" +
                    "\tmeeting_id int not null\n" +
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
        Complaint complaint = new Complaint(1,"sherry", "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"luke", "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint);
        Complaint complaint3 = new Complaint(3,"Jawa", "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint);

        Assertions.assertEquals(1, savedComplaint.getComplaintID());

    }
    @Test
    void get_Complaint_By_ID_Test()
    {
        Complaint complaint = new Complaint(1,"sherry", "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"luke", "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3,"Jawa", "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        Complaint savedComplaint4 = complaintDAO.getComplaintByID(1);

        Assertions.assertEquals(1, savedComplaint4.getComplaintID());
    }

    @Test
    void update_Complaint_Priority_Test()
    {
        Complaint complaint = new Complaint(1,"sherry", "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"luke", "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3,"Jawa", "Luke is lying", Priority.PENDING, 1);
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

        Complaint complaint = new Complaint(1,"sherry", "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"luke", "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3,"Jawa", "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        List<Complaint> compaintList2 = complaintDAO.getListOfComplaints();
        System.out.println(compaintList2);

        Assertions.assertEquals(3,compaintList2.size());
    }

    @Test
    void update_Complaint_Meeting_Test()
    {
        Complaint complaint = new Complaint(1,"sherry", "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"luke", "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3,"Jawa", "Luke is lying", Priority.PENDING, 1);
        Complaint savedComplaint3 = complaintDAO.createComplaint(complaint3);

        Complaint updatedComplaint = complaintDAO.updateComplaintMeeting(1, 2);
        Complaint updatedComplaint2 = complaintDAO.updateComplaintMeeting(2, 2);
        Complaint updatedComplaint3 = complaintDAO.updateComplaintMeeting(3, 2);

    }
    @Test
    void delete_Complaint_By_ID_Test()
    {
        Complaint complaint = new Complaint(1,"sherry", "Darth vader destroyed my house again", Priority.PENDING, 1);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Complaint complaint2 = new Complaint(2,"luke", "Jawas stole something", Priority.PENDING, 1);
        Complaint savedComplaint2 = complaintDAO.createComplaint(complaint2);
        Complaint complaint3 = new Complaint(3,"Jawa", "Luke is lying", Priority.PENDING, 1);
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
