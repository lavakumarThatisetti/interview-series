package com.lavakumar.interview.javaquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MutableClass {
    String name;
    List<Integer> integerList;

    public MutableClass(String name, List<Integer> integerList) {
        this.name = name;
        this.integerList = integerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}

final class ImMutableClass {
    private final String name;
    private final List<Integer> integerList;

    public ImMutableClass(String name, List<Integer> integerList) {
        this.name = name;
        this.integerList = integerList;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getIntegerList() {
        return new ArrayList<>(integerList);
    }
}

public class ImmutableDemo {
    public static void main(String[] args) {
        MutableClass mutableClass = new MutableClass("Even", new ArrayList<>(Arrays.asList(2,4,6)));
        System.out.println(mutableClass.getName());
        // We Can access and change the behaviour of fields
        mutableClass.setName("New Name");
        mutableClass.setIntegerList(Arrays.asList(2,4,6,8));
        mutableClass.getIntegerList().add(8);
        System.out.println(mutableClass.getName());
        System.out.println(mutableClass.getIntegerList());

        ImMutableClass imMutableClass = new ImMutableClass("Odd", new ArrayList<>(Arrays.asList(1,3,5)));
        System.out.println(imMutableClass.getName());
        // imMutableClass.name = "New Name";
        // System.out.println(mutableClass.getName());
        //  imMutableClass.integerList = Arrays.asList(1,3,5,6);
        imMutableClass.getIntegerList().add(6);
        System.out.println(imMutableClass.getIntegerList());


    }
}
