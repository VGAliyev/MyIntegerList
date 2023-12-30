package ru.skypro.course2.valiyev.IntegerList.exception;

public class IntegerListIndexOutOfRangeException extends RuntimeException {
    public IntegerListIndexOutOfRangeException() {
    }

    public IntegerListIndexOutOfRangeException(String message) {
        super(message);
    }

    public IntegerListIndexOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerListIndexOutOfRangeException(Throwable cause) {
        super(cause);
    }

    public IntegerListIndexOutOfRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
