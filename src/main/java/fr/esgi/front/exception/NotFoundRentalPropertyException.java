package fr.esgi.front.exception;

public class NotFoundRentalPropertyException extends RuntimeException {
    public NotFoundRentalPropertyException(String message) {
        super(message);
    }
}
