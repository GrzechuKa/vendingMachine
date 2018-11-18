package pl.sdacademy.vending.contoller;

import pl.sdacademy.vending.contoller.service.EmployeeService;
import pl.sdacademy.vending.model.Tray;

import java.util.Optional;
import java.util.Scanner;

public class EmployeeOpetationControler {

    public final EmployeeService employeeService;

    public EmployeeOpetationControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public void addTray() {
        String traySymbol = getTraySymbolFromUser();
        Long price = getTrayPriceFromUser();

        Tray newTray = Tray.builder(traySymbol)
                .price(price)
                .build();

        Optional<String> errorMessege = employeeService.addTray(newTray);
        System.out.println(errorMessege.orElse("Tray has been added"));
    }

    private String getTraySymbolFromUser() {
        System.out.print(" > Provide tray symbol :");
        return getUserInput().toUpperCase();
    }

    private Long getTrayPriceFromUser() {
        while (true) {
            System.out.println("Provide tray price : ");
            try {
                return Long.parseLong(getUserInput());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Try again!!!");
            }
        }
    }

    private String getUserInput() {
        return new Scanner(System.in).nextLine();
    }

}
