package pl.sdacademy.vending.repository;

import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.service.repository.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.io.*;
import java.util.Optional;

public class HardDriveVendingMachineRepository implements VendingMachineRepository {

    private final String repoLocaton;

    public HardDriveVendingMachineRepository(Configuration configuration) {
        repoLocaton = configuration.getStringPropoerty("repository.harddrive.vm.path", "VendingMachine.ser");

    }

    @Override
    public VendingMachine save(VendingMachine machine) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(repoLocaton))) {
            objectOutputStream.writeObject(machine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return machine;
    }

    @Override
    public Optional<VendingMachine> load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(repoLocaton))) {
            VendingMachine readObject = (VendingMachine) objectInputStream.readObject();
            return Optional.ofNullable(readObject);
        } catch (IOException e) {
            System.out.println("Vending Machin Repo file not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not found repo Vending Machine Class");
        }
        return Optional.empty();
    }
}
