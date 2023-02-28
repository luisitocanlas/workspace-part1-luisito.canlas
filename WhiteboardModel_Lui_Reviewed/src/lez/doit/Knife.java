package lez.doit;

/**
 * JR: Demonstrates good understanding of program concepts.
 * Like the package name!
 * A few unnecessary checks for valid property values in the business methods,
 * and a few other minor improvements could be made, but very good overall.
 *
 * See comments below and in the other classes.
 *
 * Code is clean, readable, well-formatted.
 *
 * Class participation is good and has been improving even more, keep it up.
 *
 * Class names, package names, and overall structure are correct.
 */
public class Knife {
    // CLASS (static) VARIABLES
    public static final int MIN_SHARPNESS = 1;
    public static final int MAX_SHARPNESS = 50;
    public static final double MIN_LENGTH = 2.5;

    // properties, fields
    private KnifeTypes type;
    private Double length; // constraint: length >= 2.0 [JR: comment error, should be 2.5]
    private int sharpness = 25;  // default sharpness 25, constraint: 1 - 50

    // constructors
    public Knife(KnifeTypes type, Double length) {      // Must input type and length
        setType(type);
        setLength(length);
    }

    public Knife(KnifeTypes type, Double length, int sharpness) {
        this(type, length);
        setSharpness(sharpness);
    }

    // methods
    /*
     * JR: nice idea, that chopping reduces sharpness.
     * No need to check for MIN_LENGTH though, since that's handled in the setter.
     */
    public void chop() {
        if (sharpness >= 3 && length >= MIN_LENGTH) {
            setSharpness(sharpness - 2);
            System.out.printf("Chopping with %s. Sharpness is now %s\n", getType(), getSharpness());
        }
        else if (length < MIN_LENGTH) {
            System.out.printf("Your %s needs to have at least a length of %s", getType(), MIN_LENGTH);
        }
        else {
            System.out.printf("%s is not sharp enough to chop. Please sharpen your %s\n", getType(), getType());
        }
    }

    /*
     * JR: again, nice idea.
     * See comment above chop() regarding the MIN_LENGTH check.
     */
    public void slice() {
        if (sharpness >= 2 && length >= MIN_LENGTH) {
            setSharpness(sharpness - 1);
            System.out.printf("Slicing with %s. Sharpness is now %s\n", getType(), getSharpness());

        }
        else if (length < MIN_LENGTH) {
            System.out.printf("Your %s needs to have at least a length of %s", getType(), MIN_LENGTH);
        }
        else {
            System.out.printf("%s is not sharp enough to slice. Please sharpen your %s\n", getType(), getType());
        }
    }

    /*
     * JR: and again here, no need to check for MIN_LENGTH, since that's handled in the setter.
     */
    public void sharpen() {
        if (sharpness >= MIN_SHARPNESS && sharpness < MAX_SHARPNESS && length >= MIN_LENGTH) {
            setSharpness(MAX_SHARPNESS);
            System.out.printf("Sharpening %s to %s\n", getType(), MAX_SHARPNESS);
        }
        else if (length < MIN_LENGTH) {
            System.out.printf("Your %s needs to have at least a length of %s", getType(), MIN_LENGTH);
        }
        else {
            System.out.printf("Your %s is already sharp enough.\n", getType());
        }
    }

    // getters and setters, accessors
    public KnifeTypes getType() {
        return type;
    }

    public void setType(KnifeTypes type) {
        this.type = type;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        if (length >= MIN_LENGTH){
            this.length = length;
        }
        else {
            // JR: incorrect message, should be this:
            // System.out.printf("Invalid length value: %s. Length must be more than or equal to %s\n", length, MIN_LENGTH);;

            // this is yours
            System.out.printf("Invalid length value: %s. Length must be more than or equal to 2.5", MIN_LENGTH);;
        }
    }

    public int getSharpness() {
        return sharpness;
    }

    public void setSharpness(int sharpness) {
        if (sharpness >= MIN_SHARPNESS && sharpness <= MAX_SHARPNESS) {
            this.sharpness = sharpness;
        }
        else {
            System.out.printf("Invalid sharpness value: %s. Sharpness must be between %s to %s.\n", sharpness, MIN_SHARPNESS, MAX_SHARPNESS);
        }
    }

    // toString()
    public String toString() {
        /*
         * JR: it's okay that you check for null here (since a Double can be null),
         * but it would be better to reject a null length at instantiation time, via
         * having this null check in the setter instead.
         */
        if (length == null) {
            return String.format("ERROR: Your %s needs to have at least a length of %s", getType(), MIN_LENGTH);
        }
        else {
            return String.format("Knife: type = %s, blade length = %s, sharpness = %s", getType(), getLength(), getSharpness());
        }
    }
}