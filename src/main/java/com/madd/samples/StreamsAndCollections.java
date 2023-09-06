package com.madd.samples;

import com.madd.samples.Utils.StreamUtils;
import com.madd.samples.models.Order;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAndCollections {

    public static void main(String[] args) {
        StreamsAndCollections sc = new StreamsAndCollections();
        // Filter examples.
        List<Integer> evenNumbers = StreamUtils.filterList(Arrays.asList(1, 2, 3, 4, 5, 6, 7), (s) -> s % 2 == 0);
        System.out.println(evenNumbers);
        // Map examples
        List<String> lList = Arrays.asList("one", "two", "three", "four");
        Function<String, String> upperFunction = s -> s.toUpperCase();
        List<String> uList = StreamUtils.mapList(lList, upperFunction);
        System.out.println(uList);
        Function<String, Integer> lenFunction = val -> val.length();
        List<Integer> countList = StreamUtils.mapList(uList, lenFunction);
        countList.forEach(System.out::println);
        String min = Stream.of("11", "adsasd", "sadasdad").min(Comparator.comparing(String::length)).get();
        System.out.println("###");
        System.out.println(min);
        Integer sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).reduce((i1, i2) -> {
            System.out.println(String.format("First parameter: %s and second parameter: %s", i1, i1));
            return i1 + i2;
        }).get();
        System.out.println(sum);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .peek(System.out::println)
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);
        numbers.stream().reduce(0, Integer::sum);

        String res = Stream.of("1", "A", "B", "D", "3", "X").reduce("", (pev, nex) -> {
            return pev.concat("-").concat(nex);
        });

        System.out.println(res);

        Comparator<? super Integer> sortFun = (i, j) -> Integer.compare(j, i);
        Stream.of(1, 2, 5, 3, 4, 6, 42, 2, 6, 8, 8, 34, 6, 43).sorted(sortFun)
                .collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
        //sc.listToMap();
        //sc.strListTomap();
    }

    public void listToMap() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("name1", 100));
        orders.add(new Order("name1", 20));
        orders.add(new Order("name2", 30));
        orders.add(new Order("name3", 220));
        orders.add(new Order("name2", 433));
        Map<String, Integer> orderMap = orders.stream().collect(Collectors.groupingBy(Order::getName, Collectors.summingInt(Order::getCount)));
        orderMap.entrySet().stream().forEach(System.out::println);
    }

    public void strListTomap() {
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");
        strList.add("6");
        List<Integer> intList =
                // strList.stream().map(a -> Integer.parseInt(a)).collect(Collectors.toList());
                strList.stream().map(Integer::parseInt).collect(Collectors.toList());
        intList.forEach(System.out::println);
    }

    public void filterList() {
    }
}
