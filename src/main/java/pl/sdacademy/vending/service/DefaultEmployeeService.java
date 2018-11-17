package pl.sdacademy.vending.service;

import pl.sdacademy.vending.contoller.service.EmployeeService;
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
    public Optional<String> addTray(Tray tray) {
        Optional<VendingMachine> optionalVendingMachine = machineRepository.load();
        VendingMachine vendingMachine = optionalVendingMachine.orElseGet(() -> new VendingMachine(configuration));

        if (vendingMachine.placeTray(tray)) {
            machineRepository.save(vendingMachine);
            return Optional.empty();
        } else {
            return Optional.of("Not add tray");
        }
    }
}
