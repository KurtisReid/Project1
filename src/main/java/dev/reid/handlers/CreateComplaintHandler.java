package dev.reid.handlers;

import com.google.gson.Gson;
import dev.reid.app.App;
import dev.reid.entity.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import kotlin.comparisons.ComparisonsKt;
import org.jetbrains.annotations.NotNull;

public class CreateComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Complaint complaint = gson.fromJson(json, Complaint.class);

        Complaint registeredComplaint = App.complaintService.registerComplaint(complaint);
        String complaintJson = gson.toJson(registeredComplaint);

        ctx.status(201);
        ctx.result("201");
    }
}
