package edu.snooze;

/*
 * Test class focused on validation testing.
 * We will do BVT (Boundary Value Testing) for snoozeInterval:
 *  range: 1-20 (inclusive)
 *  need to check on the boundaries
 *  0,1  and  20,21
 */
class AlarmClockValidationTest {

    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock();

       clock.setSnoozeInterval(1);    // no error message
        System.out.println("snoozeInterval: " + clock.getSnoozeInterval());  // should be 1

        clock.setSnoozeInterval(20);  // no error message
        System.out.println("snoozeInterval: " + clock.getSnoozeInterval());  // should be 20

        clock.setSnoozeInterval(0);   // should see error message, should still be 20 (from before)
        clock.setSnoozeInterval(21);  // error message, should still be 20
        System.out.println("snoozeInterval: " + clock.getSnoozeInterval());  // should still be 20
    }
}