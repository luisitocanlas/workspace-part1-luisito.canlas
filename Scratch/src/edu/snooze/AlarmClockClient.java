package edu.snooze;

/*
 * The application "main-class" (class with the main() method).
 * Every Java application has ONE main-class, and usually many "business" classes.
 *
 * Here, we will create a few instances of AlarmClock and give them a basic test-drive.
 */
class AlarmClockClient {

    // ENTRY point or starting point of every standalone Java application
    // The application "starts here"
    public static void main(String[] args) {
        // create an instance of AlarmClock and set its properties
        AlarmClock clock1 = new AlarmClock();
        clock1.setSnoozeInterval(AlarmClock.MAX_INTERVAL);  // snooze as long as possible each time
        clock1.setRepeat(7);

        // call methods on it
        clock1.snooze();

        // create a second instance (object) of AlarmClock via the snoozeInterval ctor
        AlarmClock clock2 = new AlarmClock(10);

        // call methods on it, also
        clock2.snooze();

        // create a third AlarmClock object via the snoozeInterval-repeat ctor
        AlarmClock clock3 = new AlarmClock(10, 3);  //snoozeInterval, repeat

        // call methods on this one, too
        clock3.snooze();

        // show their toString() methods in action
        System.out.println(clock1.toString());
        System.out.println(clock2.toString());
        System.out.println(clock3); // toString() is automatically called
    }
}