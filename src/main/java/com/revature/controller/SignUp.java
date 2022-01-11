package com.revature.controller;

import io.javalin.Javalin;

public class SignUp {

    private static Javalin app;

    public static void displaySignUp(String[] args) {
        app = Javalin.create(); //this represents the configuration of the framework at runtime

//        app.get("/signup", ((ctx) -> {
//            String url = ctx.url();
//            ctx.html("");
//            ctx.status(200);
//        }));

        app.start(); //now run the app




    }
}
