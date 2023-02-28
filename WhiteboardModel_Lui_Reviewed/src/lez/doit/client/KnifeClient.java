package lez.doit.client;

import lez.doit.Knife;
import lez.doit.KnifeTypes;

/*
 * JR: good basic test drive of a few valid instances.
 * Shows that sharpen(), chop(), and slice() work correctly.
 */
class KnifeClient {
    public static void main(String[] args) {
        // initialize and set properties
        Knife k1 = new Knife(KnifeTypes.CHEFS_KNIFE, 8.0);
        k1.setSharpness(40);

        Knife k2 = new Knife(KnifeTypes.CLEAVER, 6.5, 44);

        Knife k3 = new Knife(KnifeTypes.PETTY_KNIFE, 3.5);


        // call methods
        System.out.println(k1);
        k1.sharpen();           // sharpness will be set to 50
        k1.chop();              // sharpness will decrease by 2
        k1.slice();             // sharpness will decrease by 1
        System.out.println();   // line space

        System.out.println(k2);
        k2.chop();              // sharpness will decrease by 2
        k2.slice();             // sharpness will decrease by 1
        k2.sharpen();           // sharpness will be set to 50
        System.out.println();   // line space

        System.out.println(k3);
        k3.chop();              // sharpness will decrease by 2
        k3.sharpen();           // sharpness will be set to 50
        k3.slice();             // sharpness will decrease by 1
        System.out.println();   // line space

        // call toString()
        System.out.println(k1.toString());
        System.out.println(k2);
        System.out.println(k3);
    }
}