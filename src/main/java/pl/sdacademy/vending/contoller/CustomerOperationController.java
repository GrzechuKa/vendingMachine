package pl.sdacademy.vending.contoller;

import pl.sdacademy.vending.model.VendingMachine;

public class CustomerOperationController {
    private final VendingMachine machine;

    public CustomerOperationController(VendingMachine machine) {
        this.machine = machine;
    }

    public void printMachine() {

        for (int rowNo = 0; rowNo < machine.rowCount(); rowNo++) {
            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
               printUpperBoundary(rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printSymbol(rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printLowerBoundary(rowNo, colNo);
            }
            System.out.println();
        }
    }

    private void printUpperBoundary( int rowNo, int colNo){
        System.out.print("+--------+");
    }

    private void printSymbol( int rowNo, int colNo){
        char charTemp = (char) ('A' + rowNo);
        System.out.print("|   " + charTemp + (colNo + 1) + "   |");
    }

    private void printLowerBoundary( int rowNo, int colNo){
        System.out.print("+--------+");
    }
}
