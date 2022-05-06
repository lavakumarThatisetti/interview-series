package com.lavakumar.interview.javaquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreamQuestions {
    public static void main(String[] args) {

        // convert list to Map  square the values in array and make it key,value
        List<Integer> numbers = Arrays.asList(2,3,4);
        Map<Integer, Integer> collect = numbers.stream().collect(Collectors.toMap(integer -> integer, integer -> integer * integer));
        System.out.println(collect);

        // Count Occurrences Using Streams - ASKED IN GOLDMAN SACHS
        List<String> list = Arrays.asList("Apple", "Orange", "Apple", "Apple", "Orange");
        Map<String, Long> result = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        Map<String, Long> resultConMap = list.stream()
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
        System.out.println(resultConMap);



    }
}
