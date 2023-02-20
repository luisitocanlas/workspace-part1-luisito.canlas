package lez.doit.test;

import lez.doit.Knife;
import lez.doit.KnifeTypes;

class KnifeValidationTest {

    public static void main(String[] args) {
        Knife k0 = new Knife(KnifeTypes.CHEFS_KNIFE, 8.0);

        k0.setSharpness(1);         // should stick
        System.out.println(k0);

        k0.setSharpness(50);        // should stick
        System.out.println(k0);

        k0.setSharpness(0);         // error, cannot set below 1, should still be 50
        System.out.println(k0);

        k0.setSharpness(51);        // error, cannot set above 50, should still be 50
        System.out.println(k0);

        k0.setSharpness(1);
        k0.slice();                 // error, sharpness cannot go below 1
        k0.chop();                  // error, sharpness cannot go below 1

        k0.setSharpness(50);
        k0.sharpen();               // error, cannot set to 50 if already at 50

        System.out.println(k0);

        System.out.println();       // line space

        Knife k1 = new Knife(KnifeTypes.CLEAVER, 2.0);  // error message, length must be >= 2.5
        System.out.println();       // line space
        System.out.println(k1);     // error message, must define length
        k1.setLength(4.0);
        System.out.println(k1);
    }
}