package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

public class VendingMachine {


    private final Configuration configuration;
    private final Long rowsCount;
    private final Long colsCount;

    public VendingMachine(Configuration configuration) {
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        if(rowsCount <=0 || rowsCount > 9){
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        colsCount = configuration.getLongProperty("machine.size.cols", 4L);
        if(colsCount() <= 0 || colsCount > 26){
            throw new IllegalArgumentException("Cols count " + colsCount() + " is invalid");
        }
    }

    public Long rowCount(){
        return rowsCount;
    }

    public  Long colsCount(){
        return colsCount;
    }



}
