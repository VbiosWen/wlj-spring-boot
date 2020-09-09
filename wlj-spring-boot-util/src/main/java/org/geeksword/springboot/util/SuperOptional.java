package org.geeksword.springboot.util;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author vbiso
 * @see
 */
public class SuperOptional<T> {

    private final T value;

    private static final SuperOptional<?> EMPTY = new SuperOptional<>();

    public SuperOptional() {
        this.value = null;
    }

    public SuperOptional(T value) {
        this.value = value;
    }

    public static <T> SuperOptional<T> empty() {
        @SuppressWarnings("unchecked")
        SuperOptional<T> optional = (SuperOptional<T>) EMPTY;
        return optional;
    }

    public static <T> SuperOptional<T> of(T value) {
        return new SuperOptional<>(value);
    }

    public static <T> SuperOptional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("the value is null");
        }
        return this.value;
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public void isPresent(Consumer<? super T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    public <U> SuperOptional<U> map(Function<? super T,? extends U> mapper){
        if(isPresent()){
        Objects.requireNonNull(mapper);
            return SuperOptional.ofNullable(mapper.apply(value));
        }else{
            return empty();
        }
    }


}
