package com.lavakumar.interview.javaquestions;

import java.util.Arrays;
import java.util.Collection;
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

        // flatMap convert list of lists to one list and sort it
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfLists =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("Before flattening is : " + listOfLists);
        // Using flatMap
        List<Integer> listOfInts  = listOfLists.stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("After flattening is : " + listOfInts);

    }
}
