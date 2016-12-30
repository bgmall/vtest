package cache;

import com.github.benmanes.caffeine.cache.CacheWriter;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.RemovalCause;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by msg on 2016/12/9.
 */
public class CacheMain {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Pair createPair() {
        return null;
    }

    public static void main(String[] args) {
        LoadingCache<Integer, Pair> build = Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(10)
                .writer(new CacheWriter<Integer, Pair>() {
                    @Override
                    public void write(@Nonnull Integer key, @Nonnull Pair value) {

                    }

                    @Override
                    public void delete(@Nonnull Integer key, @Nullable Pair value, @Nonnull RemovalCause cause) {

                    }
                })
                .build(key -> createPair());
    }
}
