package gov.research;

import java.util.Arrays;

class ArraysTest {

    public static void main(String[] args) {
        int[] ages = new int[2];
        ages[0] = 56;
        ages[1] = 49;
        System.out.println(ages);                   // toString() (NOT useful)
        System.out.println(Arrays.toString(ages));  // more like it!
        System.out.println();

        double[] prices = {9.99, 37.49, 32.5, 49.96};
        System.out.println("price has length: " + prices.length);
        System.out.println(Arrays.toString(prices));
        System.out.println();

        String[] names = {"lui", "gura", "momo", "larry"};
        System.out.println(Arrays.toString(names));
        System.out.println();

        for (String name : names) {
            System.out.println(name);
        }
    }
}