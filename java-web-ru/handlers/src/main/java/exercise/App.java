package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create();
        app.get("/phones", ctx -> ctx.json(Data.getPhones()));
        app.get("/domains", ctx -> ctx.json(Data.getDomains()));

        app.get("/html", ctx -> {
            ctx.contentType("text/html");
            ctx.result("<h1>Hello Hexlet</h1>");
        });

        app.get("/plain", ctx -> {
            ctx.body();
            ctx.header("Content-Type");
            ctx.result("<h1>Hello Hexlet</h1>");
        });

        app.get("/status_header", ctx -> {
            ctx.status(403);
            ctx.header("KEY", "value");
        });

        app.get("/users", ctx -> {
            // Отдаем обратно url + query params
            ctx.result(ctx.fullUrl());
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1); // Определяем тип параметра однозначно или дифолт
        });

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
