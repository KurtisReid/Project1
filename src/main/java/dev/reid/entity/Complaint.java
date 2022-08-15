package dev.reid.entity;

public class Complaint {

    private int id;

    private String constituent_submission;

    private String complaint_desc;

    private Priority priority;

    private int meeting_id;

    public Complaint(int id, String constituent_submission, String complaint_desc, Priority priority, int meeting_id) {
        this.id = id;
        this.constituent_submission = constituent_submission;
        this.complaint_desc = complaint_desc;
        this.priority = priority;
        this.meeting_id = meeting_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstituent_submission() {
        return constituent_submission;
    }

    public void setConstituent_submission(String constituent_submission) {
        this.constituent_submission = constituent_submission;
    }

    public String getComplaint_desc() {
        return complaint_desc;
    }

    public void setComplaint_desc(String complaint_desc) {
        this.complaint_desc = complaint_desc;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", constituent_submission='" + constituent_submission + '\'' +
                ", complaint_desc='" + complaint_desc + '\'' +
                ", priority=" + priority +
                ", meeting_id=" + meeting_id +
                '}';
    }
}
