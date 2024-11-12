package Exercises;

import Entities.Password;
import Exceptions.InvalidPasswordException;

import java.util.Scanner;

public class PasswordReader {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Type a password: ");
        String password = sc.nextLine();

        try{
            var pw = new Password(password);

            System.out.println("Password saved");
        } catch (InvalidPasswordException e){
            System.out.println(e.getMessage());
        }

    }
}
