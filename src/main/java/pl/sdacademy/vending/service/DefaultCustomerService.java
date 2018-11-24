package pl.sdacademy.vending.service;

import pl.sdacademy.vending.contoller.service.CustomerService;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.model.VendingMachineSnapshot;
import pl.sdacademy.vending.service.repository.VendingMachineRepository;

import java.util.Optional;

public class DefaultCustomerService implements CustomerService {
    private final VendingMachineRepository machineRepository;

    public DefaultCustomerService(VendingMachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Optional<Product> buyProductFtomTray(String traySymbol) {
        Optional<VendingMachine> loaded = machineRepository.load();
        if(loaded.isPresent()){
            VendingMachine machine = loaded.get();
            Optional<Product> boughtProduct = machine.buyProductWithSymbol(traySymbol.toUpperCase());
            machineRepository.save(machine);
            return boughtProduct;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<VendingMachineSnapshot> loadMachineToPrint() {
        Optional<VendingMachine> loadedMachine = machineRepository.load();
        return loadedMachine.map(VendingMachine::snapshot);
    }
}
