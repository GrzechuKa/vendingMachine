package pl.sdacademy.vending.contoller;

import pl.sdacademy.vending.contoller.service.CustomerService;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.TraySnapshot;
import pl.sdacademy.vending.model.VendingMachineSnapshot;
import pl.sdacademy.vending.util.StringUtil;

import java.util.Optional;
import java.util.Scanner;

public class CustomerOperationController {
    private final CustomerService customerService;
    private final Integer trayWidth = 12;

    public CustomerOperationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void printMachine() {
        Optional<VendingMachineSnapshot> loadedMachine = customerService.loadMachineToPrint();
        if(!loadedMachine.isPresent()){
            System.out.println("Vending Machine out of servive");
            return;
        }
        VendingMachineSnapshot machine = loadedMachine.get();
        for (int rowNo = 0; rowNo < machine.getRowsCount(); rowNo++) {
            for (int colNo = 0; colNo < machine.getsColsCount(); colNo++) {
               printUpperBoundary(machine, rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.getsColsCount(); colNo++) {
                printSymbol(machine, rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.getsColsCount(); colNo++) {
               printNameProduct(machine, rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.getsColsCount(); colNo++) {
                printPriceProduct(machine, rowNo, colNo);
            }
            System.out.println();
            for (int colNo = 0; colNo < machine.getsColsCount(); colNo++) {
                printLowerBoundary(machine, rowNo, colNo);
            }
            System.out.println();
        }
    }

    public void buyProduct(){
        System.out.print("> Tray symbol :");
        String traySymbol = new Scanner(System.in).nextLine();
        Optional<Product> product = customerService.buyProductFtomTray(traySymbol);
        if (product.isPresent()) {
            System.out.println("You buy product : " + product.get().getName());
        } else {
            System.out.println("Out of stock");
        }
    }

    private void printUpperBoundary(VendingMachineSnapshot machine, int rowNo, int colNo){
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }

    private void printSymbol(VendingMachineSnapshot machine, int rowNo, int colNo){
        Optional<TraySnapshot> tray = machine.getTray(rowNo, colNo);
        String traySymbol = tray.map(TraySnapshot::getSymbol).orElse("--");
        System.out.print("|" + StringUtil.adjustText(traySymbol, trayWidth) + "|");
    }
    private void printNameProduct(VendingMachineSnapshot machine, int rowNo, int colNo){
        String formattedName = machine.getTray(rowNo, colNo)
                .map(TraySnapshot::getProduct)
                .orElse("--");
        System.out.print("|" + StringUtil.adjustText(formattedName, trayWidth) + "|");
    }
    private void printPriceProduct(VendingMachineSnapshot machine, int rowNo, int colNo){
        Long price = machine.getTray(rowNo, colNo)
                .map(TraySnapshot::getPrice)
                .orElse(0L);

        String formatedMoney = StringUtil.formatMoney(price);
        String centredMoney = StringUtil.adjustText(formatedMoney, trayWidth);
        System.out.print("|" + centredMoney + "|");
    }

    private void printLowerBoundary(VendingMachineSnapshot machine, int rowNo, int colNo){
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }
}
