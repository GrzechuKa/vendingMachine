package pl.sdacademy.vending.service;

import pl.sdacademy.vending.contoller.service.EmployeeService;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.service.repository.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;

public class DefaultEmployeeService implements EmployeeService {
    private final VendingMachineRepository machineRepository;
    private final Configuration configuration;

    public DefaultEmployeeService(VendingMachineRepository machineRepository, Configuration configuration) {
        this.machineRepository = machineRepository;
        this.configuration = configuration;
    }

    @Override
    public Optional<String> addTray(String traySymbol, Long price) {
        Optional<VendingMachine> optionalVendingMachine = machineRepository.load();
        VendingMachine vendingMachine = optionalVendingMachine.orElseGet(() -> new VendingMachine(configuration));

        if (vendingMachine.placeTray(Tray.builder(traySymbol).price(price).build())) {
            machineRepository.save(vendingMachine);
            return Optional.empty();
        } else {
            return Optional.of("Not add tray");
        }
    }

    @Override
    public Optional<String> removeTrayWithSymbol(String traySymbol) {
        Optional<VendingMachine> optionalVendingMachine = machineRepository.load();

        if (optionalVendingMachine.isPresent()) {
            VendingMachine vendingMachine = optionalVendingMachine.get();
            Optional<Tray> removeOptional = vendingMachine.removeTrayWithSymbol(traySymbol);

            if (removeOptional.isPresent()) {
                machineRepository.save(vendingMachine);
                return Optional.empty();
            } else {
                return Optional.of("Could not remove tray, chcec provided position");
            }
        } else {
            return Optional.of("There is not Machine");
        }
    }

    @Override
    public Optional<String> addProduct(String symbolTray, String productName, Integer numberAddProduct) {
        Optional<VendingMachine> optionalVendingMachine = machineRepository.load();

        if (optionalVendingMachine.isPresent()) {
            VendingMachine vendingMachine = optionalVendingMachine.get();
            Integer productAdd = numberAddProduct;

            for (int i = 0; i < numberAddProduct; i++) {
                if (vendingMachine.addProductToTray(symbolTray, new Product(productName))) {
                    productAdd--;
                } else {
                    return Optional.of("Not add " + productAdd + "products");
                }
            }
            machineRepository.save(vendingMachine);
            return Optional.empty();
        } else {
            return Optional.of("No machine");

        }


    }

    @Override
    public Optional<String> changePrice(String traySymbol, Long updatedPrice) {
        Optional<VendingMachine> loadedMachine = machineRepository.load();
        if (loadedMachine.isPresent()) {
            VendingMachine machine = loadedMachine.get();
            boolean successful = machine.updatePriceForSymbol(traySymbol, updatedPrice);
            if (successful) {
                machineRepository.save(machine);
                return Optional.empty();
            } else {
                return Optional.of("Could not change price, check tray symbol");
            }
        }
        return Optional.of("There is no Vending Machine, create one first");
    }
}
