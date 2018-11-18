package pl.sdacademy.vending;

import java.util.Arrays;

public enum UserMenuSelection {

    BUY_PRODUCT(1, "Buy product"),
    EXIT(9, "Exit"),
    SERVICE_MENU(0, "Servive menu");

    private final Integer optionNumber;
    private final String optionText;

    UserMenuSelection(Integer optionNumber, String optionText) {
        this.optionNumber = optionNumber;
        this.optionText = optionText;
    }

    public static UserMenuSelection selectionForOptionNumber(Integer requestedOptionNumber) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.getOptionNumber().equals(requestedOptionNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknow option number: " + requestedOptionNumber));
    }


    public Integer getOptionNumber() {
        return optionNumber;
    }

    public String getOptionText() {
        return optionText;
    }

//    kod napisany przeze mnie bez strumieni powyżej metoda ze strumieniami
//    public static UserMenuSelection selectionForOptionNumber(Integer requestedOptionNumber) {
//
//        for (UserMenuSelection menuSelection : UserMenuSelection.values()) {
//            if (requestedOptionNumber == menuSelection.getOptionNumber()) {
//                return menuSelection;
//            }
//        }
//        throw new IllegalArgumentException("unknow option number: " + requestedOptionNumber);
//    }

}
