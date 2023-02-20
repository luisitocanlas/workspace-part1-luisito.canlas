package lez.doit.client;

import lez.doit.Knife;
import lez.doit.KnifeTypes;

import java.util.Arrays;

class KnifeClientArgs {

    public static void main(String[] args) {
        // check for required arguments
        if (args.length < 3) {
            String usage = "Usage: java KnifeClientArgs <KnifeTypes> <length> <sharpness>";
            String example = "Example: java KnifeClientArgs CHEFS_KNIFE 8.0 40";

            String note1 = "Supported types are: " + Arrays.toString(KnifeTypes.values());
            String note2 = String.format("Length must be at least %s", Knife.MIN_LENGTH);
            String note3 = String.format("Sharpness must be between %s and %s", Knife.MIN_SHARPNESS, Knife.MAX_SHARPNESS);

            System.out.println(usage + "\n" + example + "\n" + note1 + "\n" + note2+ "\n" + note3);
            return; // return from main()
        }

        // check if you got the arguments
        System.out.printf("You provided %s arguments\n", args.length);

        // convert string outputs into the proper type
        KnifeTypes type = KnifeTypes.valueOf(args[0]);
        double length = Double.parseDouble(args[1]);
        int sharpness = Integer.parseInt(args[2]);

        // create instance from the converted inputs
        Knife knife = new Knife(type, length, sharpness);
        System.out.println("Thank you for your purchase!");
        System.out.printf("Your custom %s is being processed.\n", knife.getType());
        System.out.println(knife);
    }
}