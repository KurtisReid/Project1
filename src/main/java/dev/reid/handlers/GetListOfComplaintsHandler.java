package dev.reid.handlers;

import com.google.gson.Gson;
import dev.reid.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetListOfComplaintsHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        System.out.println("GetListOfComplaints");
        Gson gson = new Gson();
        String json = gson.toJson(App.complaintService.viewComplaints());
        ctx.result(json);

    }
}
