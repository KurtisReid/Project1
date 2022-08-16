package dev.reid.entity;

public class Complaint {

    private int complaintID;

    private String constituentSubmission;

    private String complaintDesc;
    

    private Priority priority;

    private int meetingID;
    

    public Complaint(int id, String constituent_submission, String complaint_desc, Priority priority, int meeting_id) {
        this.complaintID = id;
        this.constituentSubmission = constituent_submission;
        this.complaintDesc = complaint_desc;
        this.priority = priority;
        this.meetingID = meeting_id;
    }

    public Complaint() {

    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public String getConstituentSubmission() {
        return constituentSubmission;
    }

    public void setConstituentSubmission(String constituentSubmission) {
        this.constituentSubmission = constituentSubmission;
    }

    public String getComplaintDesc() {
        return complaintDesc;
    }

    public void setComplaintDesc(String complaint_desc) {
        this.complaintDesc = complaint_desc;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(String priority) {

        if (priority.toUpperCase() == Priority.ADDRESSED.name())
        {
            this.priority = Priority.ADDRESSED;
        } else if (priority.toUpperCase() == Priority.LOW.name())
        {
            this.priority = Priority.LOW;
        } else if (priority.toUpperCase() == Priority.IGNORED.name())
        {
            this.priority = Priority.IGNORED;
        } else if (priority.toUpperCase() == Priority.HIGH.name())
        {
            this.priority = Priority.HIGH;
        } else
        {
            this.priority = Priority.PENDING;
        }

    }

    public int getMeetingId() {
        return meetingID;
    }

    public void setMeetingId(int meeting_id) {
        this.meetingID = meeting_id;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + complaintID +
                ", constituent_submission='" + constituentSubmission + '\'' +
                ", complaint_desc='" + complaintDesc + '\'' +
                ", priority=" + priority +
                ", meeting_id=" + meetingID +
                '}';
    }
}
