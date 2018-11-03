package pl.sdacademy.vending.contoller;

import pl.sdacademy.vending.model.VendingMachine;

public class CustomerOperationController {
    private VendingMachine machine;

    public CustomerOperationController() {
        machine = new VendingMachine();
    }

    public void printMachine() {
        char charTemp = 'A';

        for (int i = 0; i < machine.rowCount(); i++) {
            for (int j = 0; j < machine.colCount(); j++) {
                System.out.print("+--------+");
            }
            System.out.println();
            for (int j = 0; j < machine.colCount(); j++) {
                System.out.print("|   " + charTemp + (j + 1) + "   |");
            }
            System.out.println();
            for (int j = 0; j < machine.colCount(); j++) {
                System.out.print("+--------+");
            }
            System.out.println();

            charTemp++;
        }
    }
}
