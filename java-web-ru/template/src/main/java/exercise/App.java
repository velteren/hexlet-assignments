package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            UserPage user = null;
            for (var item: USERS) {
                if (item.getId() == id) {
                    user = new UserPage(item);
                }
            }
            if (user != null) {
                ctx.render("users/show.jte", Collections.singletonMap("user", user));
            } else {
                throw new NotFoundResponse("User not found");
            }
        });
        app.get("/users", ctx -> {
            var users = new UsersPage(USERS);
            ctx.render("users/index.jte", Collections.singletonMap("users", users));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
