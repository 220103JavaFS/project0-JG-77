package com.revature;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.revature.controller.Controller;
import io.javalin.Javalin;

public class Driver {
    private static Javalin app;
   // private static Logger log = LoggerFactory.getLogger(Driver.class);
//    public static void main(String[] args) {
//
//        configure();
//
//        app.start(); //Synchronously starts the application instance on the configured port
//    }

    public static void configure(Controller... controllers){

        for(Controller c:controllers){
            //addRoutes() from Controller class
            c.addRoutes(app); //everything gets the app object to add routes
        }
    }
}