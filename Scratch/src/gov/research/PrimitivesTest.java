package gov.research;

class PrimitivesTest {

    public static void main(String[] args) {
        int age = 32;
        System.out.println("The age is: " + age);

        // for long, you need to add an L after the number
        long population = 7_000_000_000L;
        System.out.println("The population is: " + population);

        double height = 167.64;
        System.out.println("My height is: " + height);

        boolean isTall = false;
        System.out.println("I am tall? " + isTall);

        char grade = 'B';
        System.out.println("I got a " + grade + " on the test");

        System.out.println("My favorite word is \"belly\"");

        int i = 18;
        System.out.println(i);

        int j = i;
        System.out.println(j);

        i++; // i is 19 now, what is j??? STILL 18
        System.out.println(i);
        System.out.println(j);

        // i++  pre increment
        // ++i  post increment
        int n = 3;
        System.out.println(n++); // shows a 3 and THEN n becomes 4
        System.out.println(n);   // n is OF COURSE 4 now
    }
}