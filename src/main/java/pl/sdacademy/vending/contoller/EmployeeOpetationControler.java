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

    public void removeTray() {
        Optional<String> retmoveTray = employeeService.removeTrayWithSymbol(getTraySymbolFromUser());
        System.out.println(retmoveTray.orElse("Tray has been removed"));
    }

    public void changePrice(){
        String traySymbol = getTraySymbolFromUser();
        Long price = getTrayPriceFromUser();
        Optional<String> changePrice = employeeService.changePrice(traySymbol, price);
        if(changePrice.isPresent()){
            System.out.println(changePrice);
        } else{
        System.out.println("Price changed");
        }
    }

    public void addProducts() {
        Optional<String> errorMessage = employeeService.addProduct(getTraySymbolFromUser(), getNameProductFromUser(), getQuantityOfProductsFromUser());
        System.out.println(errorMessage.orElse("All products has been added"));
    }

    private String getNameProductFromUser() {
        System.out.print(" > Provide name Products :");
        return getUserInput().toUpperCase();
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
    private Integer getQuantityOfProductsFromUser() {
        Integer quantity = null;
        while (quantity == null) {
            System.out.print(" > Provided product quantity: ");
            try {
                quantity = Integer.parseInt(getUserInput());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
        return quantity;
    }


    private String getUserInput() {
        return new Scanner(System.in).nextLine();
    }

}
