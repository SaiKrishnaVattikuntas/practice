package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressions {
    public static void main(String[] args) {

        // Question 1)  Convert a Runnable using lambda expression.
        // ---------------------------------------------------------------------
        //Traditional Old Way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                System.out.println("Implementing Runnable in Traditional Way..");
            }
        };

        new Thread(runnable).start();

        //Using Lambda Functions..
        new Thread(() -> System.out.println("Implementing Runnable using Lambda..")).start();

        // ----------------------------------------------------------------------------------------------------

        // Question 2)   Sort a list of strings using lambda.
        //----------------------------------------------------------------
        // 1st way
        List<String> stringList = Arrays.asList("Krishna", "Mallika", "Vattikunta", "Linga",
                "Seetha", "Murali", "Lokesh", "Siva", "Srinu");
        stringList.sort((name1, name2) -> name1.compareTo(name2));
        stringList.forEach(System.out::println);

        //2nd way
        stringList.sort(String::compareTo);
        stringList.forEach(System.out::println);
        //----------------------------------------------------------------------------------

        //Question 3)  Create a lambda that adds two integers
        //----------------------------------------------------------------------------------------
        //traditional way
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("----->Sum:" + c);

        //Using Lambda..
        BiFunction<Integer, Integer, Integer> sum = (d, e) -> d + e;
        System.out.println("Sum using Lamba.." + sum.apply(20, 30));

        //---------------------------------------------------------------------------------------
        //Question 4) Create a lambda that converts a string to uppercase.
        //----------------------------------------------------------------------------------
        Function<String, String> s2 = String::toUpperCase;
        System.out.println(s2.apply("Krishna Loves Mouni"));

        //-----------------------------------------------------------------------------------------------

        //Question 5) Create a lambda that checks if a number is even.
        //----------------------------------------------------------------------------------------------------------

        Predicate<Integer> checkEven = (n) -> n % 2 == 0;
        System.out.println("Even Number:" + checkEven.test(9));
        System.out.println("Even Number:" + checkEven.test(20));

        //-----------------------------------------------------------------------------------------------

    }


}
