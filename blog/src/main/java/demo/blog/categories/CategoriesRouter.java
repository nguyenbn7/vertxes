package demo.blog.categories;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class CategoriesRouter {

  public void GET(RoutingContext context) {
    context.json(new JsonObject().put("message", "GET /api/categories"));
  }

  private void POST(RoutingContext context) {
    context.json(new JsonObject().put("message", "POST /api/categories"));
  }

  public static Router mount(Vertx vertx) {
    Router router = Router.router(vertx);

    router.get().handler(context -> new CategoriesRouter().GET(context));
    router.post().handler(context -> new CategoriesRouter().POST(context));

    return router;
  }
}
