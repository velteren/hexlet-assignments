package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx, int pageNum) {
        var posts = PostRepository.getEntities();
        var len = posts.size();
        int fullPages = len / 5;
        int lastPage = fullPages + 1;
        if (pageNum > lastPage) {
            pageNum = lastPage;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        var isLastPage = pageNum == lastPage;
        List<Post> sublist;
        if (isLastPage) {
            sublist = posts.subList(pageNum * 5 - 5, posts.size() - 1);
        } else {
            sublist = posts.subList(pageNum * 5 - 5, pageNum * 5);
        }
        var page = new PostsPage(sublist, pageNum);
        var map = Collections.singletonMap("page", page);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new PostPage(user);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
