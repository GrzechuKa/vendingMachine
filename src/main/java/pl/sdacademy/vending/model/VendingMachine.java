package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

import java.io.Serializable;
import java.util.Optional;

public class VendingMachine implements Serializable {
    public static final long serialVersionUID = 1L;
    private final Long rowsCount;
    private final Long colsCount;
    private final Tray[][] trays;

    public VendingMachine(Configuration configuration) {
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        if (rowsCount <= 0 || rowsCount > 9) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        colsCount = configuration.getLongProperty("machine.size.cols", 4L);
        if (colsCount() <= 0 || colsCount > 26) {
            throw new IllegalArgumentException("Cols count " + colsCount() + " is invalid");
        }
        trays = new Tray[rowsCount.intValue()][colsCount.intValue()];
    }

    public Optional<Tray> getTrayAtPosition(int rowNo, int colNo) {
        //tacke opakowana w optional jesli nie ma to pusty optional
        try {
            Tray tray = trays[rowNo][colNo];
            Optional<Tray> wrapperTray = Optional.ofNullable(tray);
            return wrapperTray;
        } catch (ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public Long rowCount() {
        return rowsCount;
    }

    public Long colsCount() {
        return colsCount;
    }

    public Optional<String> productNameAtPosition(Integer rowNo, Integer colNo) {
        Optional<Tray> tray = getTrayAtPosition(rowNo, colNo);
        if (tray.isPresent()) {
            return tray.get().firstProductName();
        }
        return Optional.empty();
    }


    public Optional<Product> buyProductWithSymbol(String traySymbol) {
        for (int rowNo = 0; rowNo < rowsCount; rowNo++) {
            for (int colNo = 0; colNo < colsCount; colNo++) {
                Tray tray = trays[rowNo][colNo];
                if (tray == null) {
                    continue;
                }
                if (tray.getSymbol().equals(traySymbol)) {
                    return tray.buyProduct();
                }
            }
        }
        return Optional.empty();
    }

    public boolean placeTray(Tray tray) {
        String symbol = tray.getSymbol();
        if (symbol.length() != 2) {
            return false;
        }
        Integer rowNo = symbol.charAt(0) - 'A';
        Integer colNo = symbol.charAt(1) - '1';
        if (rowNo < 0 || rowNo >= rowsCount || colNo < 0 || colNo >= colsCount) {
            return false;
        }
        Optional<Tray> trayOptional = getTrayAtPosition(rowNo, colNo);
        if (trayOptional.isPresent()) {
            return false;
        } else {
            trays[rowNo][colNo] = tray;
            return true;
        }
    }

    public Optional<Tray> removeTrayWithSymbol(String traySymbol) {
        if (traySymbol.length() != 2) {
            return Optional.empty();
        }
        Integer rowNo = traySymbol.charAt(0) - 'A';
        Integer colNo = traySymbol.charAt(1) - '1';
        Optional<Tray> trayAtPosition = getTrayAtPosition(rowNo, colNo);
        if (trayAtPosition.isPresent()) {
            trays[rowNo][colNo] = null;
        }
        return trayAtPosition;
    }
}

