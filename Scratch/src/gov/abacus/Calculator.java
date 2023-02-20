package gov.abacus;

import java.util.Arrays;

/*
 * This is an "all-static" class, i.e., a class definition with nothing
 * but static methods. These are called from the client as Calculator.methodName().
 */
class Calculator {

    /**
     * Returns the arithmetic mean (average) of the supplied integers.
     */
    public static double average(int first, int... rest) {
        double result = 0.0;
        double sum = first;

        for (int value : rest) {
            sum += value;   // sum = sum + rest
        }

        result = sum / (rest.length + 1);
        return result;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    /**
     * Returns a random integer between 1 and 14 (inclusive).
     * <p>
     * HINT: see a class called Math in the Java API (package java.lang)
     * Look for a helpful method here to get you started.
     * NOTE: these methods in the Math class are all "static", which means you call them as so:
     * Math.methodName()
     */
    public static int randomInt() {
        return randomInt(1, 14);    // delegate to the min-max version with a 1 and a 14
    }

    /**
     *
     */
    public int randomInt(int max) {
        return randomInt(1, max);
    }

    /**
     * Returns a random integer between 'min' and 'max' (inclusive).
     * We use the same method name as above for simplicity form the client perspective.
     * That is, client has "two" flavors of randomInt to choose from.
     * This is called method "overloading".
     */
    public static int randomInt(int min, int max) {    // e.g., 5 to 75
        int result = 0;

        double rand = Math.random();                        // 0.000000 to  0.999999
        double scaled = (rand * (max - min + 1)) + min;     // 5.000000 to 75.999993

        // truncate the decimal portion off via explicit downcast to int
        result = (int) scaled;
        return result;
    }
}