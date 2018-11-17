package pl.sdacademy.vending;

import pl.sdacademy.vending.contoller.CustomerOperationController;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.Configuration;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    Configuration configuration = new Configuration();
    VendingMachine vendingMachine = new VendingMachine(configuration);
    CustomerOperationController customerOperationController = new CustomerOperationController(vendingMachine);

    private void startApplication() {
        while (true) {
            customerOperationController.printMachine();
            printMenu();
            try {
                UserMenuSelection userSelection = getUserSelection();
                switch (userSelection) {
                    case BUY_PRODUCT:
                        //1. pobierz od urzytkownika symbol tacki
                        //2. wysywolac odpowiedni mtede z kontorlera
                        //Optional byProductForSymbol(String traySymbol)
                        //3. Jeżeli udało sie kupic produkt
                        //Wypsisz na ekran potwierdzenie ze udlo sie zakupic  i znazwe
                        // 4. jeśli nie wyświetlić że brak produktu
                        System.out.print("> Tray symbol :");
                        String traySymbol = new Scanner(System.in).nextLine();
                        Optional<Product> product = customerOperationController.buyProductForSymbol(traySymbol);
                        if(product.isPresent()){
                            System.out.println("You buy product : " + product.get().getName());
                        } else {
                            System.out.println("No product");
                        }
                        break;
                    case EXIT:
                        System.out.println("Bye");
                        return;
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printMenu() {
        UserMenuSelection[] allPossibleSelections = UserMenuSelection.values();
        for (UserMenuSelection menuPosition : allPossibleSelections) {
            System.out.println(menuPosition.getOptionNumber() + ". " + menuPosition.getOptionText());
        }
    }

    private UserMenuSelection getUserSelection() {
        System.out.print(" > Your selection: ");
        String userSelection = new Scanner(System.in).nextLine();
        try {
            Integer menuNumber = Integer.valueOf(userSelection);
            return UserMenuSelection.selectionFrooptionNumber(menuNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection format");
        }
    }

    public static void main(String[] args) {
        new Main().startApplication();


    }

}
