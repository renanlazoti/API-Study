package Entities;

import Exceptions.DivisorSameZeroException;

public class Number {
    private double numberOne, numberTwo;

    public Number(double numberOne, double numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        if (numberTwo == 0){
            throw new DivisorSameZeroException("The application can't be executate because the divisor can't be same that 0");
        }
    }

    public double divisionOperation(){
        return numberOne / numberTwo;
    }
}