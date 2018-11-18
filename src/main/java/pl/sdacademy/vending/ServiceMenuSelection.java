package pl.sdacademy.vending;

import java.util.Arrays;

public enum ServiceMenuSelection {
    ADDTRAY(1, "Add new tray to machine"),
    REMOVE_TRAY(2, "Remove tray"),
    ADD_PRODUCT_FOR_POSIOTON(3, "Add product for posiotion"),
    REMOVE_PRODUCT_FROM_TRAY(4, "Remove product from tray"),
    CHANGE_PRICE(5, "Change price"),
    EXIT(9, "Exit service menu");


    private final Integer optionNumber;
    private final String optionMessage;

    ServiceMenuSelection(Integer optionNumber, String optionMessage) {
        this.optionNumber = optionNumber;
        this.optionMessage = optionMessage;
    }

    public Integer getOptionNumber() {
        return optionNumber;
    }

    public String getOptionMessage() {
        return optionMessage;
    }

    public static ServiceMenuSelection selectionForOptionNumber (Integer requestOptionNumber){
        return Arrays.stream(ServiceMenuSelection.values())
                .filter(x -> x.optionNumber.equals(requestOptionNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknow option number: " + requestOptionNumber));
    }
}
