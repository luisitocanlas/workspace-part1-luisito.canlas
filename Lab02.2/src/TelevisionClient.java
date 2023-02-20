/*
 * Application "main-class" (class with a main() class).
 * We'll create a few instances of Television and give them a basic test drive.
 */
class TelevisionClient {

    // STARTING point for any standalone Java application
    public static void main(String[] args) {
        System.out.println(Television.getInstanceCount() + " instances");
        System.out.println();

        // create instances and set properties
        Television tv1 = new Television();
        tv1.setBrand("Samsung");
        tv1.setVolume(Television.MIN_VOLUME);                                                   // turn it down!
        tv1.setDisplay(DisplayType.OLED);

        Television tv2 = new Television("Sony", Television.MAX_VOLUME, DisplayType.PLASMA);     // louder!!!

        Television tv3 = new Television("LG");


        // call on the methods
        tv1.turnOn();
        tv2.turnOn();
        tv3.turnOn();
        System.out.println();   // blank line in the output

        tv1.turnOff();
        tv2.turnOff();
        tv3.turnOff();
        System.out.println();

        // call toString()
        System.out.println(tv1.toString());
        System.out.println(tv2);    // toString() automatically called
        System.out.println(tv3);
        System.out.println();

        System.out.println(Television.getInstanceCount() + " instances");
    }
}