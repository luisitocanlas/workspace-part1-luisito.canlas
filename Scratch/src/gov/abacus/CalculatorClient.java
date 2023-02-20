package gov.abacus;

class CalculatorClient {

    public static void main(String[] args) {
//        double sum = Calculator.add(3.1, 5.1);
//        System.out.println("The sum is: " + sum);
//
//        // OK to pass ints where primitive doubles are expected
//        System.out.println("The difference is: " + Calculator.subtract(3, 5));
//        System.out.println("10 is even? " + Calculator.isEven(10));
//        System.out.println();   // blank line in the output
//
//        int winner = Calculator.randomInt();
//        System.out.println("The winner is: " + winner);
//        System.out.println();

        double avg = Calculator.average(2,6,6,5);
        System.out.println(avg);
    }
}