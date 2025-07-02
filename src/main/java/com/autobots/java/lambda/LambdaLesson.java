package com.autobots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    public static void main(String[] args) {

        MathOperation addition = (a, b) -> a + b;
        MathOperation multi = (a, b) -> a * b;

        System.out.println("5 + 3 = " + addition.operation(5, 3));
        System.out.println("5 * 3 = " + multi.operation(5, 3));
// Принимает Обьект, возврашает boolean
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println(isNotEmpty.test(""));// false
        System.out.println(isNotEmpty.test("Java"));// true


// Принимает Int, возврашает String
        Function<Integer, String> toStringFunction = i -> "Число: " + i;
        System.out.println(toStringFunction.apply(10));// Число: 10


        Consumer<String> print = s -> System.out.println("Writing: " + s);
        print.accept("Hello World"); // Writing: Hello World
        System.out.println(withoutDoubles(6, 6, true));
    }

    public static int withoutDoubles(int die1, int die2, boolean noDoubles) {

        if (noDoubles) {
            if (die1 != die2) {
                return die1 + die2;
            }
            if (noDoubles && die1 == die2) {
                return die1 + die2 + 1;
            }
            if (noDoubles && die1 == 6) {
                if (noDoubles && die2 == 6) {
                    return 6 + 1;
                }

            }
        }
                if (!noDoubles) {
                    return die1 + die2;
                }
        return die1 + die2;
            }

        }





