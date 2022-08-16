package dev.reid.services;

import dev.reid.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    Complaint registerComplaint(Complaint complaint);

    List<Complaint> viewComplaints();
}
