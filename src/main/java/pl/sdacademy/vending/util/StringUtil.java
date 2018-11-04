package pl.sdacademy.vending.util;

public class StringUtil {

    public static String adjustText(String text, Integer expectedLenght) {

        String expendedText = text;
        while (expendedText.length() < expectedLenght){
            expendedText = " " + expendedText + " ";
        }
        return expendedText.substring(0, expectedLenght);
//        if (text.length() > expectedLenght) {
//            text = text.substring(0, expectedLenght);
//
//        }
//        if ((text.length() - expectedLenght) % 2 == 0) {
//            while (text.length() < expectedLenght) {
//                text = " " + text + " ";
//            }
//        }
//        if ((text.length() - expectedLenght) % 2 != 0) {
//            text = " " + text;
//            while (text.length() < expectedLenght) {
//                text = " " + text + " ";
//            }
//        }


    }

}
