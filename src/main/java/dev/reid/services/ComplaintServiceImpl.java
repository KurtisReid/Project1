package dev.reid.services;

import dev.reid.daos.ComplaintDAO;
import dev.reid.daos.ComplaintDAOPostgres;
import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService{

    private ComplaintDAO complaintDAO = new ComplaintDAOPostgres();

    @Override
    public Complaint registerComplaint(Complaint complaint) {
        System.out.println("ComplaintService registerComplaint");
        System.out.println(complaint);

        //Complaint savedComplaint = this.complaintDAO.createComplaint(complaint);
        //System.out.println(this.complaintDAO);

        return this.complaintDAO.createComplaint(complaint);
    }

    @Override
    public List<Complaint> viewComplaints() {
        System.out.println("ComplaintService viewComplaints()");
        List<Complaint> complaintList = this.complaintDAO.getListOfComplaints();
        return complaintList;
    }

    @Override
    public Complaint attachComplaintToMeeting(int id, int newMeetingID, Priority newPriority) {
        System.out.println("ComplaintService attachComplaintToMeeting");
        System.out.println(id + " " + newMeetingID);
        return this.complaintDAO.updateComplaintMeeting(id, newMeetingID, newPriority);
    }
}
