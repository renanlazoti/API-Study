package Exceptions;

public class YearConvertionException extends RuntimeException {
    private String message;
    public YearConvertionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
