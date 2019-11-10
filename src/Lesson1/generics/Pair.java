package Lesson1.generics;

public class Pair<T, Err extends  Exception> {

    private final T value;
    private final Err error;

    public Pair(T value, Err error) {
        this.value = value;
        this.error = error;
    }

    public T getValue() {
        return value;
    }

    public Err getError() {
        return error;
    }

    public boolean hasError () {
        return  error != null;
    }

    public static <T, Err extends Exception> Pair<T, Err> create(T value) {
        return new Pair<>(value, null);
    }
}
