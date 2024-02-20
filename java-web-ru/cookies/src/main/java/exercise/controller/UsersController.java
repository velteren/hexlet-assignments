package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        if (token != null && token.equals(user.getToken())) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }

    }

    public static void register(Context ctx) {
        var token = Security.generateToken();
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email = ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var newUser = new User(firstName, lastName, email, password, token);
        UserRepository.save(newUser);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(newUser.getId()));
    }
    // END
}
