package pl.sdacademy.vending.util;

public class StringUtil {

    public static String duplicateText (String text, Integer count){
        StringBuilder duplicatedText = new StringBuilder();
        for(int i = 0; i < count; i++){
            duplicatedText = duplicatedText.append(text);
        }
        return duplicatedText.toString();
    }

    public static String adjustText(String text, Integer expectedLenght) {

        String expendedText = text;
        while (expendedText.length() < expectedLenght) {
            expendedText = " " + expendedText + " ";
        }
        return expendedText.substring(0, expectedLenght);
    }


    public static String formatMoney(Long amount) {
        return formatMoneyIntegrals(amount)
                + ","
                + formatMoneyDecimals(amount);
    }

    private static String formatMoneyIntegrals(Long amount) {
        String integrals = Long.toString(amount / 100);
        StringBuilder formattedMoney = new StringBuilder();
        Integer charactersTillLastSpace = 0;
        for (int charIndex = integrals.length() - 1; charIndex >= 0; charIndex--) {
            charactersTillLastSpace++;
            formattedMoney = formattedMoney.append(integrals.charAt(charIndex));
            if (charactersTillLastSpace >= 3) {
                formattedMoney = formattedMoney.append(" ");
                charactersTillLastSpace = 0;
            }
        }
        return formattedMoney.reverse().toString().trim();
    }

    private static String formatMoneyDecimals(Long amount) {
        String decimals = Long.toString(amount % 100);
        if (decimals.length() < 2) {
            decimals = "0" + decimals;
        }
        return decimals;
    }


//    public static String adjustText(String text, Integer expectedLenght) {

//        *Mój kod
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
//    }

    //      *Metoda napisana prze ze mnie samemu
//    public static String formatMoney(Long amount) {
//        String strintToreturn = null;
//        char[] charToFormat = String.valueOf(amount).toCharArray();
//
//        if (charToFormat.length == 1) {
//            strintToreturn = "0,0" + charToFormat[(charToFormat.length - 1)];
//        }
//        if (charToFormat.length == 2) {
//            strintToreturn = "0," + charToFormat[charToFormat.length - 2] + charToFormat[charToFormat.length - 1];
//        }
//
//        if (charToFormat.length >= 3) {
//            String penny = "," + charToFormat[charToFormat.length - 2] + charToFormat[charToFormat.length - 1];
//            strintToreturn = "" + penny;
//            int counter = 0;
//            for (int i = 0; i < (charToFormat.length - 2); i++) {
//                counter++;
//                strintToreturn = charToFormat[charToFormat.length - 3 - i] + strintToreturn;
//                if (counter % 3 == 0) {
//                    strintToreturn = " " + strintToreturn;
//                }
//            }
//        }
//        return strintToreturn.trim();
//    }

}
