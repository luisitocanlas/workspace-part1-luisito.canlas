package net.flix;

public enum Genre {
    // each of these is called by the ctor below, passing a string
    COMEDY("Comedy"),
    WESTERN("Western"),
    MYSTERY("Mystery"),
    SCI_FI("Science Fiction"),
    ACTION("Action"),
    ROMANCE("Romance"),
    DRAMA("Drama"),
    HORROR("Horror");

    // - - - - - - - - - - - - - - - - - - - -
    // everything under this line is regular class definition stuff
    // namely, fields, constructors, methods
    // - - - - - - - - - - - - - - - - - - - -
    private final String display;

    // constructor - called only from inside (8 times, from those listed above)
    Genre(String display) {
        this.display = display;
        // System.out.println("Genre ctor called");
    }

    public String getDisplay() {    // often the "get" prefix is omitted when there is no setter
        return display;
    }

    public String toString() {
        return getDisplay();
    }
}