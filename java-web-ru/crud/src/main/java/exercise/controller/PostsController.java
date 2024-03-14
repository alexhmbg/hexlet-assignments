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
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        var pageNum = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var postsToSkip = (pageNum - 1) * 5;
        List<Post> posts = PostRepository.getEntities()
                .stream()
                .skip(postsToSkip)
                .limit(5)
                .toList();

        var page = new PostsPage(posts, pageNum);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END
}
