package exception;

public class InvalidExpressionException extends RuntimeException {
    private final static String DEFAULT_MESSAGE = "올바르지 않은 수식";

    public InvalidExpressionException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidExpressionException(String msg) {
        super(msg);
    }
}
