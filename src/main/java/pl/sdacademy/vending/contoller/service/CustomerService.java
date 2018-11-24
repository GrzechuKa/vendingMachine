package pl.sdacademy.vending.contoller.service;

import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.VendingMachine;

import java.util.Optional;

public interface CustomerService {
    Optional<Product> buyProductFtomTray(String traySymbol);
    Optional<VendingMachine> loadMachineToPrint();
}
