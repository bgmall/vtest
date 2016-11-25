package servicefactories;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceException;

/**
 * Created by 37 on 2016/9/29.
 */
public class BasicServiceImpl implements BasicService {

    private int i = 0;
    private int j = 0;

    @Override
    public void find(JsonObject document, Handler<AsyncResult<JsonObject>> resultHandler) {
        JsonObject result = document.copy();
        if (!document.containsKey("name")) {
            resultHandler.handle(ServiceException.fail(NO_NAME_ERROR, "No name in the document"));
        } else if (document.getString("name").isEmpty() || document.getString("name").equalsIgnoreCase("bad")) {
            resultHandler.handle(ServiceException.fail(BAD_NAME_ERROR, "Bad name in the document: " +
                    document.getString("name"), new JsonObject().put("name", document.getString("name"))));
        } else {
            result.put("approved", true);
            resultHandler.handle(Future.succeededFuture(result));
        }
    }

    @Override
    public void hello(String key, Handler<AsyncResult<String>> resultHandler) {
        String result = "hello world";
        i++;
        resultHandler.handle(Future.succeededFuture(result));
    }

    @Override
    public void call(String key) {
        j++;
    }
}
