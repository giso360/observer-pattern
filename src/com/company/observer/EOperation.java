package com.company.observer;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum EOperation {

    CHANGE_PRICE("CHANGE PRICE"),
    CHANGE_STOCK_VALUE("CHANGE STOCK VALUE"),
    NONE("NONE");

    private final String operationName;

    EOperation(String operationName) {
        this.operationName = operationName;
    }

    public static EOperation getOperation(String operationName) {
        try {
            return Optional.of(Arrays.asList(EOperation.values()).
                    stream().filter(eOperation -> eOperation.getOperationName().equalsIgnoreCase(operationName)).
                    collect(Collectors.toList()).get(0)).get();
        } catch (Exception e) {
            System.out.println("No such operation found ... return none !!!");
            return EOperation.NONE;
        }
    }

    public String getOperationName() {
        return this.operationName;
    }
}
