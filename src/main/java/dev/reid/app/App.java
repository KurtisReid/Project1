package dev.reid.app;

import dev.reid.handlers.CreateComplaintHandler;
import dev.reid.handlers.CreateMeetingHandler;
import dev.reid.handlers.GetListOfComplaintsHandler;
import dev.reid.services.ComplaintService;
import dev.reid.services.ComplaintServiceImpl;
import dev.reid.services.MeetingService;
import dev.reid.services.MeetingServiceImpl;
import io.javalin.Javalin;

public class App {

    public static ComplaintService complaintService = new ComplaintServiceImpl();
    public static MeetingService meetingService = new MeetingServiceImpl();

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();
        GetListOfComplaintsHandler getListOfComplaintsHandler = new GetListOfComplaintsHandler();
        CreateMeetingHandler createMeetingHandler = new CreateMeetingHandler();

        app.put("/complaint", createComplaintHandler);
        app.get("/complaint", getListOfComplaintsHandler);
        app.put("/meeting", createMeetingHandler);

        app.start();

    }
}
