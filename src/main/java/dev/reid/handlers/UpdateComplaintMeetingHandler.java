package dev.reid.handlers;

import com.google.gson.Gson;
import dev.reid.app.App;
import dev.reid.entity.Complaint;
import dev.reid.entity.Priority;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintMeetingHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        System.out.println("UpdateComplaintMeetingHandler");
        //"/complaint/{complaint_id}/{meeting_id}"
        int complaintId = Integer.parseInt(ctx.pathParam("complaint_id"));
        int meetingID = Integer.parseInt(ctx.pathParam("meeting_id"));


        String expenseJson = ctx.body();
        Gson gson = new Gson();
        System.out.println("UpdateComplaintMeetingHandler");

        Complaint complaint = gson.fromJson(expenseJson, Complaint.class);
        // MADE IT

        Complaint registeredComplaint = App.complaintService.attachComplaintToMeeting(complaintId, meetingID, Priority.HIGH);

        String complaintJson = gson.toJson(registeredComplaint);

        ctx.status(201);
        ctx.result("201");


    }
}
