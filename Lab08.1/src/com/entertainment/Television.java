package com.entertainment;

/*
 * Business class to model the workings of a television set.
 * No main() method here.
 */
public class Television {
    // CLASS (static) VARIABLES - shared among all instances - these live up in that shared common area
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 100;
    public static final String[] VALID_BRANDS = {"Samsung", "LG", "Sony", "Toshiba"};

    private static int instanceCount = 0;

    public static int getInstanceCount() {
        return instanceCount;
    }

    // - - - - - - - - - - - - - - - - - -

    // attributes or properties, called "fields" or "instance variable"
    private String brand;          // = "Toshiba";  // brand name, default value if client doesn't give one
    private int volume;            // = 1;          // current volume, default value if client doesn't give one
    private DisplayType display = DisplayType.LED;  // null if we don't provide a default

    // Television HAS-A Tuner - delegates to it for all things channel-related
    private Tuner tuner = new Tuner();      // instantiated internally, not exposed(no get/set)

    private boolean isMuted;
    private int oldVolume;         // not exposed via get/set methods - internal use only

    // constructors
    public Television() {
        instanceCount++;           // instanceCount = instanceCount + 1
    }

    public Television(String brand) {
        this();
        setBrand(brand);           // delegate to setter for any validation/conversion
    }

    public Television(String brand, int volume) {
        this(brand);               // delegate to ctor above me for brand
        setVolume(volume);         // handle volume myself, by delegating to its setter
    }

    public Television(String brand, int volume, DisplayType display) {
        this(brand, volume);       // delegate to brand-volume ctor for those two
        setDisplay(display);       // handle display myself, by delegating to its setter
    }

    // functions or operations, called "methods" in Java | business-oriented methods
    public void turnOn() {
        // call private method for this task
        boolean isConnected = verifyInternetConnection();

        System.out.println("Turning on your " + getBrand() + " TV to volume " + getVolume());
    }

    public void turnOff() {
        System.out.println("Shutting down...goodbye");
    }

    public void mute() {
        if (!isMuted()) {   // not currently muted
            oldVolume = getVolume();
            setVolume(0);
            isMuted = true;
        }
        else {              // are currently muted
            setVolume(oldVolume);
            isMuted = false;
        }
    }

    public void changeChannel(String channel) {
        // delegate to the tuner
        tuner.setChannel(channel);
    }

    public String getCurrentChannel() {
        // delegate to the tuner
        return tuner.getChannel();
    }

    // setter and getter | accessor methods - provide "controlled access" to the object's internal (private) dat
    public boolean isMuted() {
        return isMuted;
    }

    public String getBrand() {
        return brand;
    }

    // data constraint: [Samsung, LG, Sony, Toshiba]
    public void setBrand(String brand) {

//        for (String validBrand : VALID_BRANDS) {
//            if (validBrand.equalsIgnoreCase(brand)) {
//                this.brand = validBrand;
//                return;
//            }
//        }
//        System.out.println("Invalid brand: " + brand + ". Available brands are Samsung, LG, Sony, or Toshiba");

//        if (brand.equals("Samsung") ||
//            brand.equals("LG")      ||
//            brand.equals("Sony")    ||
//            brand.equals("Toshiba")) {
//            this.brand = brand;
//        }
//        else {
//            System.out.println("Invalid brand: " + brand + ". Available brands are Samsung, LG, Sony, or Toshiba");
//        }

        /*
        switch (brand) {
            case "Samsung":
            case "LG":
            case "Sony":
            case "Toshiba":
                this.brand = brand;
                break;
            default:
                System.out.println("Invalid brand: " + brand + ". Available brands are Samsung, LG, Sony, or Toshiba");
        }
        */

        if (isValidBrand(brand)) {
            this.brand = brand;
        }
        else {                                       // prints out error message if we don't have a match
            System.out.println("Invalid brand: " + brand + ". Available brands are Samsung, LG, Sony, or Toshiba");
        }
    }

    // data constraint: [Samsung, LG, Sony, Toshiba]
    private static boolean isValidBrand(String brand) {
        boolean valid = false;

        for (String validBrand : VALID_BRANDS) {
            if (validBrand.equals(brand)) {          // we have a match
                valid = true;
                break;                               // terminates the loop since we have a match
            }
        }
        return valid;
    }

    public int getVolume() {
        return volume;
    }

    // data constraint: must be [0-100] - use your class constants (MIN/MAX_VOLUME)
    public void setVolume(int volume) {
        if (MIN_VOLUME <= volume && volume <= MAX_VOLUME) {     // valid
            this.volume = volume;
            isMuted = false;
        }
        else {
            System.out.printf("Invalid volume: %s. Volume should be set between %s - %s.\n", volume, MIN_VOLUME, MAX_VOLUME);

//            System.out.println("Invalid volume: " + volume + ". Volume should be set between " + MIN_VOLUME + "-" + MAX_VOLUME);
        }
    }

    public DisplayType getDisplay() {
        return display;
    }

    public void setDisplay(DisplayType display) {
        this.display = display;
    }

    private boolean verifyInternetConnection() {
        return true;    // fake implementation
    }

    // toString()
    public String toString() {
        String volumeString = isMuted() ? "<muted>" : String.valueOf(getVolume());

        return String.format("Television: brand=%s, volume=%s, display=%s, channel=%s", getBrand(), volumeString, getDisplay(), getCurrentChannel());

//        return "Television: brand=" + getBrand() + ", volume=" + volumeString + ", display=" + getDisplay();
    }
}