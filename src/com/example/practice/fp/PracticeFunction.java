package com.example.practice.fp;

import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

public class PracticeFunction {

    private static Function<String, String> uppercase = String::toUpperCase;
    private static Function<String, String> replaceSpace = input -> input.replaceAll(" ", "_");
    private static Function<Object, Object> logToConsole = input ->  {
            System.out.println(input.toString());
            return null;
    };

    static BiFunction<Object, Function<Object, Object>, Object>  zipNullable = (o1, o2) -> {
        if (o1 != null & o2 != null) {
            return o2.apply(o1);
        }
        return null;
    };
    public static void main(String[] args) {

        Function pipeline = uppercase
                .andThen(replaceSpace)
                .andThen(logToConsole);

        pipeline.apply("This is example of functional programming");

        zipNullable(null, logToConsole);

        doIfTrue(2!=2, x -> logToConsole.apply(x));
    }

    static Optional<Object> zipNullable(Object o1, Function<Object, Object> onNotNull) {
        return Optional.ofNullable(zipNullable.apply(o1, onNotNull));
    }

    static void doIfTrue(Boolean o1, Consumer<Boolean> onTrue) {
       doIfTrue.accept(o1, onTrue);
    }

    private static BiConsumer<Boolean, Consumer<Boolean>> doIfTrue = (b, c) -> {
        if(b) c.accept(true);
    };

    private static BiFunction<Boolean, Function<Boolean, Object>, Object> takeIfTrue = (b, c) -> {
        if(b) return c.apply(true);
        return null;
    };
}
