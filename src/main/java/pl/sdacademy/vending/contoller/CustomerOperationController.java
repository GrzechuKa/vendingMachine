package pl.sdacademy.vending.contoller;

import pl.sdacademy.vending.model.VendingMachine;

public class CustomerOperationController {
    private VendingMachine machine;

    public CustomerOperationController() {
        machine = new VendingMachine();
    }

    public void printMachine() {


        for (int rowNo = 0; rowNo < machine.rowCount(); rowNo++) {
            for (int colNo = 0; colNo < machine.colCount(); colNo++) {
               printUpperBoundary(rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.colCount(); colNo++) {
                printSymbol(rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.colCount(); colNo++) {
                printLowerBoundary(rowNo, colNo);
            }
            System.out.println();

        }
    }

    public void printUpperBoundary( int rowNo, int colNo){
        System.out.print("+--------+");
    }

    public void printSymbol( int rowNo, int colNo){
        char charTemp = (char) ('A' + rowNo);
        System.out.print("|   " + charTemp + (colNo + 1) + "   |");
    }

    public void printLowerBoundary( int rowNo, int colNo){
        System.out.print("+--------+");
    }
}
