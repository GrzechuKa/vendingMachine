package pl.sdacademy.vending.contoller.service;

import pl.sdacademy.vending.model.Tray;

import java.util.Optional;

public interface EmployeeService {

    Optional<String> addTray (String traySymbol, Long price);
    Optional<String> removeTrayWithSymbol(String traySymbol);
    Optional<String> addProduct(String symbolTray, String productName, Integer numberAddProduct);
    Optional<String> changePrice (String traySymbol, Long updatedPrice);


}
