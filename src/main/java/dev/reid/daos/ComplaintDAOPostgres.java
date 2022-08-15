package dev.reid.daos;

import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;

import java.util.List;

public class ComplaintDAOPostgres implements ComplaintDAO{
    @Override
    public Complaint createComplaint(Complaint complaint) {
        return null;
    }

    @Override
    public Complaint getComplaintByID(int id) {
        return null;
    }

    @Override
    public Complaint updateComplaintPriority(int id, Priority priority) {
        return null;
    }

    @Override
    public List<Complaint> getListOfClomplaints() {
        return null;
    }

    @Override
    public Complaint updateComplaintMeeting(int id, String newMeetingId) {
        return null;
    }

    @Override
    public boolean deleteComplaintByID(int id) {
        return false;
    }
}
