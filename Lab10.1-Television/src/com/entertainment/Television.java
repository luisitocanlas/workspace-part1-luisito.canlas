package com.entertainment;

import java.util.Arrays;

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

    private boolean isMuted;
    private int oldVolume;         // not exposed via get/set methods - internal use only

    // constructors
    public Television() {
        instanceCount++;           // instanceCount = instanceCount + 1
    }

    public Television(String brand) throws InvalidBrandException {
        this();
        setBrand(brand);           // delegate to setter for any validation/conversion
    }

    public Television(String brand, int volume) throws IllegalArgumentException, InvalidBrandException {
        this(brand);               // delegate to ctor above me for brand
        setVolume(volume);         // handle volume myself, by delegating to its setter
    }

    public Television(String brand, int volume, DisplayType display)
            throws IllegalArgumentException, InvalidBrandException {
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
        } else {              // are currently muted
            setVolume(oldVolume);
            isMuted = false;
        }
    }

    // setter and getter | accessor methods - provide "controlled access" to the object's internal (private) dat
    public boolean isMuted() {
        return isMuted;
    }

    public String getBrand() {
        return brand;
    }

    // data constraint: must be [Samsung, LG, Sony, Toshiba]
    // I am possibly going to throw a CHECKED exception (Exception).
    // NOTE: Because it's CHECKED, I *must* declare it in a 'throws' clause.
    // The compiler "checks" to make sure I'm doing this (to be a good citizen)
    public void setBrand(String brand) throws InvalidBrandException {
        if (isValidBrand(brand)) {  // valid
            this.brand = brand;
        }
        else{                       // invalid
            throw new InvalidBrandException(String.format("Invalid brand: %s. Available brands are %s.",
                    brand, Arrays.toString(VALID_BRANDS)));
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
    // NOTE: I am possibly going to throw an UNCHECKED exception (IllegalArgumentException)
    // I do not need to "announce this with 'throws' because it's unchecked
    // BUT I will, as a good citizen.
    public void setVolume(int volume) throws IllegalArgumentException {
        if (MIN_VOLUME <= volume && volume <= MAX_VOLUME) {     // valid
            this.volume = volume;
            isMuted = false;
        } else {                                                // invalid
            throw new IllegalArgumentException(String.format("Invalid volume: %s. Volume should be set between %s - %s.",
                    volume, MIN_VOLUME, MAX_VOLUME));
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

        return String.format("Television: brand=%s, volume=%s, display=%s", getBrand(), volumeString, getDisplay());

//        return "Television: brand=" + getBrand() + ", volume=" + volumeString + ", display=" + getDisplay();
    }
}