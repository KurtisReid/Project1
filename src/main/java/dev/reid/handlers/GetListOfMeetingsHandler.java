package dev.reid.handlers;

import com.google.gson.Gson;
import dev.reid.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetListOfMeetingsHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(App.meetingService.viewMeetings());
        ctx.result(json);
    }
}
