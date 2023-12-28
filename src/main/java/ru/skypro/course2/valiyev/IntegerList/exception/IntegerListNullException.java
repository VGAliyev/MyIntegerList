package ru.skypro.course2.valiyev.IntegerList.exception;

public class IntegerListNullException extends RuntimeException {
    public IntegerListNullException() {
    }

    public IntegerListNullException(String message) {
        super(message);
    }

    public IntegerListNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerListNullException(Throwable cause) {
        super(cause);
    }

    public IntegerListNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
