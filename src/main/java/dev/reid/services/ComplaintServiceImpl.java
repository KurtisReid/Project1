package dev.reid.services;

import dev.reid.daos.ComplaintDAO;
import dev.reid.entity.Complaint;

public class ComplaintServiceImpl implements ComplaintService{

    private ComplaintDAO complaintDAO;

    @Override
    public Complaint registerComplaint(Complaint complaint) {

        Complaint savedComplaint = this.complaintDAO.createComplaint(complaint);
        return savedComplaint;
    }
}
