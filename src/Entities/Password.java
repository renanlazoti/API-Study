package Entities;

import Exceptions.InvalidPasswordException;

public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
        if(password.length() < 8){
            throw new InvalidPasswordException("Invalid password, the password must leastways 8 characters");
        }
    }
}
