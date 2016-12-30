package resteasy;

/**
 * Created by msg on 2016/12/30.
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public interface BasicResource {

    Executor executor = Executors.newFixedThreadPool(1);

    default <R> R executeAsync(Supplier<R> supplier) throws ExecutionException, InterruptedException {
        CompletableFuture<R> completableFuture = CompletableFuture.supplyAsync(supplier, executor);
        return completableFuture.get();
    }
}
