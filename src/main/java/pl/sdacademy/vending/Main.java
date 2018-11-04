package pl.sdacademy.vending;

import pl.sdacademy.vending.contoller.CustomerOperationController;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.Configuration;

import java.util.Scanner;

public class Main {

    Configuration configuration = new Configuration();
    VendingMachine vendingMachine = new VendingMachine(configuration);
    CustomerOperationController customerOperationController = new CustomerOperationController(vendingMachine);

    private void startApplication() {
        while (true){
        customerOperationController.printMachine();
        printMenu();
        UserMenuSelection userSelection = getUserSelection();
            switch (userSelection) {
                case BUY_PRODUCT:
                    //
                    break;
                case EXIT:
                    System.out.println("Bye");
                    return;
                    default:
                        System.out.println("Invalid selection");
            }

//        if(userSelection == 1){
//            buyProduct();
//        } else if (userSelection == 9){
//            System.out.println("Thanks!");
//            break;
//        } else {
//            System.out.println("Invalid selectrio");
//        }
        }
    }

    private void printMenu() {
        UserMenuSelection[] allPossibleSelections = UserMenuSelection.values();
        for(UserMenuSelection menuPosition: allPossibleSelections){
            System.out.println(menuPosition.getOptionText() + ". " + menuPosition.getOptionText());
        }
    }

    private UserMenuSelection getUserSelection() {
        String userSelection = new Scanner(System.in).nextLine();
        try {
            Integer menuNumber = Integer.valueOf(userSelection);
            UserMenuSelection
        }catch (NumberFormatException e){
            return null;
        }
    }

    public static void main(String[] args) {
        new Main().startApplication();


    }

}
