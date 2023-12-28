package ru.skypro.course2.valiyev.IntegerList.exception;

public class IntegerListItemNullException extends RuntimeException {
    public IntegerListItemNullException() {
    }

    public IntegerListItemNullException(String message) {
        super(message);
    }

    public IntegerListItemNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerListItemNullException(Throwable cause) {
        super(cause);
    }

    public IntegerListItemNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
