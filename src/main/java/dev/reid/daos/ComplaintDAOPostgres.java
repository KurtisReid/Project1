package dev.reid.daos;

import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;
import dev.reid.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAOPostgres implements ComplaintDAO {
    @Override
    public Complaint createComplaint(Complaint complaint) {
        System.out.println("ComplaintDAOPostgres createComplaint");
        System.out.println(complaint);
        try(Connection conn = ConnectionUtil.createConnection())
        {

            String sql = "Insert into complaint values (default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //preparedStatement.setInt(1, complaint.getId());
            preparedStatement.setString(1, complaint.getConstituentSubmission());

            preparedStatement.setString(2, complaint.getComplaintDesc());
            preparedStatement.setString(3, complaint.getPriority().name());
            preparedStatement.setInt(4, complaint.getMeetingId());



            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            System.out.println();
            rs.next();


            int generatedKey = rs.getInt("id");
            complaint.setComplaintID(generatedKey);
            preparedStatement.execute();

            return complaint;



        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Complaint getComplaintByID(int id) {
        try(Connection connection = ConnectionUtil.createConnection())
        {


            String sql = "select * from complaint where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            if (!rs.next())
            {
                throw new RuntimeException();
            }

            Complaint complaint = new Complaint();
            complaint.setComplaintID(rs.getInt("id"));
            complaint.setConstituentSubmission(rs.getString("constituent_submission_id"));
            complaint.setComplaintDesc(rs.getString("complaint_desc"));
            complaint.setPriority(rs.getString("priority"));
            complaint.setMeetingId(rs.findColumn("meeting_id"));
            System.out.println(complaint);

            return complaint;


        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Complaint updateComplaintPriority(int id, Priority priority) {
        try(Connection conn = ConnectionUtil.createConnection()) {
            //int id, double expenseCost, Status status, int employeeIssuer, String desc

            String sql = "update complaint set priority = ? where id = ?";

            Complaint complaint = getComplaintByID(id);
            if (complaint == null)
            {
                return null;
            }
            complaint.setPriority(priority.name());
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, complaint.getPriority().toString());
            preparedStatement.setInt(2, complaint.getComplaintID());
            System.out.println(preparedStatement);





            preparedStatement.executeUpdate();

            return complaint;




        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Complaint> getListOfComplaints() {
        System.out.println("ComplaintDAOPostgres getListOfComplaints");

        try (Connection conn = ConnectionUtil.createConnection())
        {
            String sql = "select * from complaint";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<Complaint> complaintList = new ArrayList<>();

            while (rs.next())
            {
                Complaint complaint = new Complaint();
                complaint.setComplaintID(rs.getInt("complaint_id"));
                complaint.setConstituentSubmission(rs.getString("constituent_submission_id"));
                complaint.setComplaintDesc(rs.getString("complaint_desc"));
                complaint.setPriority(rs.getString("priority"));
                complaint.setMeetingId(rs.findColumn("meeting_id"));
                complaintList.add(complaint);

            }

            return complaintList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Complaint updateComplaintMeeting(int id, int newMeetingId) {
        try(Connection conn = ConnectionUtil.createConnection()) {
            //int id, double expenseCost, Status status, int employeeIssuer, String desc

            String sql = "update complaint set meeting_id = ? where id = ?;";

            Complaint complaint = getComplaintByID(id);
            if (complaint == null)
            {
                return null;
            }

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, newMeetingId);
            preparedStatement.setInt(2, complaint.getComplaintID());

            complaint.setMeetingId(newMeetingId);



            preparedStatement.executeUpdate();

            return complaint;




        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteComplaintByID(int id) {
        try (Connection conn = ConnectionUtil.createConnection())
        {
            String sql = "delete from complaint where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
