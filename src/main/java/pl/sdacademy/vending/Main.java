package pl.sdacademy.vending;

import pl.sdacademy.vending.contoller.CustomerOperationController;
import pl.sdacademy.vending.contoller.EmployeeOpetationControler;
import pl.sdacademy.vending.contoller.service.CustomerService;
import pl.sdacademy.vending.contoller.service.EmployeeService;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.repository.HardDriveVendingMachineRepository;
import pl.sdacademy.vending.service.DefaultCustomerService;
import pl.sdacademy.vending.service.DefaultEmployeeService;
import pl.sdacademy.vending.service.repository.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    Configuration configuration = new Configuration();
    VendingMachineRepository vendingMachineRepository = new HardDriveVendingMachineRepository(configuration);
    EmployeeService employeeService = new DefaultEmployeeService(vendingMachineRepository, configuration);
    CustomerService customerService = new DefaultCustomerService(vendingMachineRepository);
    EmployeeOpetationControler employeeOpetationControler = new EmployeeOpetationControler(employeeService);
    CustomerOperationController customerOperationController = new CustomerOperationController(customerService);


    private void startApplication() {
        while (true) {
            customerOperationController.printMachine();
            printMenu();
            try {
                UserMenuSelection userSelection = getUserSelection();
                switch (userSelection) {
                    case BUY_PRODUCT:
                        System.out.print("> Tray symbol :");
                        String traySymbol = new Scanner(System.in).nextLine();
                        Optional<Product> product = customerOperationController.buyProductForSymbol(traySymbol);
                        if (product.isPresent()) {
                            System.out.println("You buy product : " + product.get().getName());
                        } else {
                            System.out.println("No product");
                        }
                        break;
                    case EXIT:
                        System.out.println("Bye");
                        return;
                    case SERVICE_MENU:
                        handleServiceUser();
                        break;
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

    private void handleServiceUser() {
        while (true) {
        customerOperationController.printMachine();
        printServiceMenu();
            try {
                ServiceMenuSelection serviceMenuSelection = getUserServiveSelection();
                switch (serviceMenuSelection) {
                    case ADDTRAY:
                        employeeOpetationControler.addTray();
                        break;
                    case REMOVE_TRAY:
                        employeeOpetationControler.removeTray();
                        break;
                    case ADD_PRODUCT_FOR_POSIOTON:
                        employeeOpetationControler.addProducts();
                        break;
                    case REMOVE_PRODUCT_FROM_TRAY:
                        break;
                    case CHANGE_PRICE:
                        employeeOpetationControler.changePrice();
                        break;
                    case EXIT:
                        return;
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printServiceMenu() {
        for (ServiceMenuSelection selection : ServiceMenuSelection.values()) {
            System.out.println(selection.getOptionNumber() + ". " + selection.getOptionMessage());
        }
    }

    private UserMenuSelection getUserSelection() {
        System.out.print(" > Your selection: ");
        String userSelection = new Scanner(System.in).nextLine();
        try {
            Integer menuNumber = Integer.valueOf(userSelection);
            return UserMenuSelection.selectionForOptionNumber(menuNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection format");
        }
    }

    private ServiceMenuSelection getUserServiveSelection() {
        System.out.print(" > Your selection: ");
        String userServiceSelection = new Scanner((System.in)).nextLine();
        try {
            Integer menuServiceNumber = Integer.valueOf(userServiceSelection);
            return ServiceMenuSelection.selectionForOptionNumber(menuServiceNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection format");
        }
    }

    public static void main(String[] args) {
        new Main().startApplication();


    }

}
