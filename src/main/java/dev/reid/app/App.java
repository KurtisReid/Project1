package dev.reid.app;

import dev.reid.handlers.*;
import dev.reid.services.ComplaintService;
import dev.reid.services.ComplaintServiceImpl;
import dev.reid.services.MeetingService;
import dev.reid.services.MeetingServiceImpl;
import io.javalin.Javalin;

public class App {

    public static ComplaintService complaintService = new ComplaintServiceImpl();
    public static MeetingService meetingService = new MeetingServiceImpl();

    public static void main(String[] args) {
        Javalin app = Javalin.create(config->{

            config.enableCorsForAllOrigins();
        });

        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();
        GetListOfComplaintsHandler getListOfComplaintsHandler = new GetListOfComplaintsHandler();
        CreateMeetingHandler createMeetingHandler = new CreateMeetingHandler();
        GetListOfMeetingsHandler getListOfMeetingsHandler = new GetListOfMeetingsHandler();
        UpdateComplaintMeetingHandler updateComplaintMeetingHandler = new UpdateComplaintMeetingHandler();


        app.post("/complaint", createComplaintHandler);
        app.get("/complaint", getListOfComplaintsHandler);
        app.post("/meeting", createMeetingHandler);
        app.get("/meeting", getListOfMeetingsHandler);
        app.put("/complaint/{complaint_id}/{meeting_id}", updateComplaintMeetingHandler);


        app.start();

    }
}
