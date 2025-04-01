package demo.blog.posts;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class PostsRouter {
  public static Router mount(Vertx vertx) {
    Router router = Router.router(vertx);

    router.get().handler(context -> {
      context.json(new JsonObject().put("message", "GET /api/posts"));
    });

    router.post().handler(context -> {
      context.json(new JsonObject().put("message", "POST /api/posts"));
    });

    return router;
  }
}
