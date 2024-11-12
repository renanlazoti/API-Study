package Exercises;

import Entities.Number;
import Exceptions.DivisorSameZeroException;

import java.util.Scanner;

public class NumberDivision {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Insert a number one: ");
        double numberOne = sc.nextDouble();
        System.out.println("Insert a number two: ");
        double numberTwo = sc.nextDouble();

        try {
            var nb = new Number(numberOne, numberTwo);

            System.out.println("Operation result = " + nb.divisionOperation());
        } catch (DivisorSameZeroException e){
            System.out.println(e.getMessage());
        }
    }
}
