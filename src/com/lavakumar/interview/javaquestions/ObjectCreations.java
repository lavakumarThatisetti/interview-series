package com.lavakumar.interview.javaquestions;

import java.lang.reflect.Constructor;

class FirstClass {
    public void hello(String message){
        System.out.println("Hi' There from "+message);
    }
}

public class ObjectCreations {
    public static void main(String[] args) {
     try {
         // Using new Keyword
         FirstClass firstClassObj1 = new FirstClass();
         firstClassObj1.hello("Traditional Object Creation");

         // Using Class newInstance() method
         FirstClass firstClassObj2 = FirstClass.class.newInstance();
         firstClassObj2.hello("Object Creation through Class Instance");

         // Using Class For Name (Spring)
         Object o = Class.forName("com.lavakumar.interview.javaquestions.FirstClass").newInstance();
         if (o instanceof FirstClass) {
             FirstClass firstClass = (FirstClass) o;
             firstClass.hello("Object Creation through reflections");
         }

         // Using Constructor class's newInstance() method
         Constructor<FirstClass> constructor = FirstClass.class.getDeclaredConstructor();
         FirstClass firstClass = constructor.newInstance();
         firstClass.hello("With constructor");

     }catch (Exception e){
         System.out.println(e.getMessage());
     }

    }
}

/*

Java Reflection provides ability to inspect and modify the runtime behavior of application.
it’s the backbone for most of the Java, J2EE frameworks. Some of the frameworks that use java reflection are:
Junit , Spring,

 */
