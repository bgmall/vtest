package cache;

import com.github.benmanes.caffeine.cache.CacheWriter;
import com.github.benmanes.caffeine.cache.RemovalCause;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

/**
 * Created by msg on 2016/12/12.
 */
public final class WriteBehindCacheWriter<K, V> implements CacheWriter<K, V> {

    private WriteBehindCacheWriter(Builder<K, V> builder) {

    }


    @Override
    public void write(@Nonnull K key, @Nonnull V value) {

    }

    @Override
    public void delete(@Nonnull K key, @Nullable V value, @Nonnull RemovalCause cause) {

    }

    public static final class Builder<K, V> {
        private Consumer<Map<K, V>> writeAction;
        private BinaryOperator<V> coalescr;
        private long bufferTimeNanos;

        public Builder<K, V> bufferTime(long duration, TimeUnit unit) {
            this.bufferTimeNanos = TimeUnit.NANOSECONDS.convert(duration, unit);
            return this;
        }

        public Builder<K, V> writeAction(Consumer<Map<K, V>> writeAction) {
            this.writeAction = requireNonNull(writeAction);
            return this;
        }

        public Builder<K, V> coalesce(BinaryOperator<V> coalescr) {
            this.coalescr = requireNonNull(coalescr);
            return this;
        }

        public WriteBehindCacheWriter<K, V> build() {
            return new WriteBehindCacheWriter<>(this);
        }
    }
}
