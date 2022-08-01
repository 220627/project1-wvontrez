package com.revature.frontcontroller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import io.javalin.Javalin;


public class Dispatcher {


    public Dispatcher(Javalin app){


        UserInterfaceImpl n = new UserInterfaceImpl();
        ReimbursementImpl r = new ReimbursementImpl();

        setUpEmployeePaths(app);

        app.get("/hello", context -> context.result("hello world"));
        app.get("/reimb-getter", (context) -> context.json(r.getAll()));
        app.get("/json-getter", (context) -> context.json(n.getAll()));
        app.get("/html-getter", context -> context.html("<html></html>"));

    }

    public static void setUpEmployeePaths(Javalin app){
        app.routes(() ->{
            path("/login", ()->{
              post(EmployeeController::login);
              patch(EmployeeController::logout);
            });
            path("/employee/reimbursements", ()->{
                get(EmployeeController::getUserReimbursements);
                post(EmployeeController::addNewReimbursement);
                path(":index", ()->{
                    get(EmployeeController::getAllReimbursementsByStatus);
                });
            });
            path("/admin/reimbursements", ()->{
                get(ManagerController::getAllReimbursements);
                patch(ManagerController::updateReimbursementByStatus);
                path(":index", ()->{
                    get(EmployeeController::getAllReimbursementsByStatus);
                });
            });
        });

    }
}
