package demo.blog;

import demo.blog.categories.CategoriesRouter;
import demo.blog.posts.PostsRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Router router = Router.router(vertx);

    router.route("/api/categories/*").subRouter(CategoriesRouter.mount(vertx));
    router.route("/api/posts/*").subRouter(PostsRouter.mount(vertx));

    vertx.createHttpServer()
        .requestHandler(router)
        .listen(8888)
        .onComplete(http -> {
          if (http.succeeded()) {
            startPromise.complete();
            System.out.println("HTTP server started on port 8888");
          } else {
            startPromise.fail(http.cause());
          }
        });
  }
}
