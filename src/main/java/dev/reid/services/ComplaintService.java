package dev.reid.services;

import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;

import java.util.List;

public interface ComplaintService {

    Complaint registerComplaint(Complaint complaint);

    List<Complaint> viewComplaints();

    Complaint attachComplaintToMeeting(int id, int newMeetingID, Priority newPriority);
}
