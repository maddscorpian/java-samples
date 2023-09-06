package com.madd.samples.problemsolving.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ArraySamples {


    public static void main(String[] args) {
        List<Integer> inputList;
        inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 78);

        Optional<Integer> min = inputList.stream().reduce((curr, prv) -> {
            return curr > prv ? prv : curr;
        });
        min.ifPresent(System.out::println);

        Optional<Integer> max = inputList.stream().reduce((curr, prv) -> {
            return curr < prv ? prv : curr;
        });
        max.ifPresent(System.out::println);


    }
}
