package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;

public class VendingMachine {


    private final Configuration configuration;
    private final Long rowsCount;
    private final Long colsCount;
    private final Tray[][] trays;

    public VendingMachine(Configuration configuration) {
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        if (rowsCount <= 0 || rowsCount > 9) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        colsCount = configuration.getLongProperty("machine.size.cols", 4L);
        if (colsCount() <= 0 || colsCount > 26) {
            throw new IllegalArgumentException("Cols count " + colsCount() + " is invalid");
        }
        trays = new Tray[rowsCount.intValue()][colsCount.intValue()];

        for (int rowNo = 0; rowNo < rowsCount; rowNo++) {
            for (int colNo = 0; colNo < colsCount; colNo++) {
                char letter = (char) ('A' + rowNo);
                int number = colNo + 1;
                String symbol = "" + letter + number;
                Tray tray = Tray.builder(symbol).build();
                trays[rowNo][colNo] = tray;
            }
        }
    }

    public Optional<Tray> getTrayAtPosition(int rowNo, int colNo) {
        //tacke opakowana w optional jesli nie ma to pusty optional
        try{
            Tray tray = trays[rowNo][colNo];
            Optional<Tray> wrapperTray = Optional.ofNullable(tray);
            return wrapperTray;
        } catch (ArrayIndexOutOfBoundsException e){
            return Optional.empty();
        }
//          Moj kod
//        try {
//            Optional<Tray> trayOptional = Optional.of(trays[rowNo][colNo]);
//            return trayOptional;
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return Optional.empty();
//        }
    }

    public Long rowCount() {
        return rowsCount;
    }

    public Long colsCount() {
        return colsCount;
    }


}
