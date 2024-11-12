package Exceptions;

public class DivisorSameZeroException extends RuntimeException{
        private String exceptionDivisor;

        public DivisorSameZeroException(String exceptionDivisor){
            this.exceptionDivisor = exceptionDivisor;
        }

    @Override
    public String getMessage() {
        return this.exceptionDivisor;
    }
}
