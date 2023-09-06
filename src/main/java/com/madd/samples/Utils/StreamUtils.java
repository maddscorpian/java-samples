package com.madd.samples.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamUtils {

    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
    }

    public static <T, R> List<R> mapList(List<T> list, Function<T, R> function) {
        return list.stream().map(function).collect(Collectors.toCollection(ArrayList<R>::new));
    }
}
