package servicefactories;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * Created by 37 on 2016/9/29.
 */
@ProxyGen
public interface BasicService {

    int NO_NAME_ERROR = 2;
    int BAD_NAME_ERROR = 3;

    static BasicService create(Vertx vertx) {
        return new BasicServiceImpl();
    }

    static BasicService createProxy(Vertx vertx, String address) {
        return ProxyHelper.createProxy(BasicService.class, vertx, address);
    }

    void find(JsonObject document, Handler<AsyncResult<JsonObject>> resultHandler);

    void hello(String key, Handler<AsyncResult<String>> resultHandler);

    void call(String key);
}
