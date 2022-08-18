package dev.reid.daos;

import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;

import java.util.List;

public interface ComplaintDAO {

    Complaint createComplaint(Complaint complaint);

    Complaint getComplaintByID(int id);

    Complaint updateComplaintPriority(int id, Priority priority);

    List<Complaint> getListOfComplaints();

    Complaint updateComplaintMeeting(int id, int newMeetingId, Priority newPriority);

    boolean deleteComplaintByID(int id);
}
