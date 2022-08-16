package dev.reid.app;

import dev.reid.handlers.CreateComplaintHandler;
import dev.reid.services.ComplaintService;
import dev.reid.services.ComplaintServiceImpl;
import io.javalin.Javalin;

public class App {

    public static ComplaintService complaintService= new ComplaintServiceImpl();

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        CreateComplaintHandler createComplaintHandler = new CreateComplaintHandler();

        app.get("/complaint", createComplaintHandler);

        app.start();

    }
}
