package Calculator;

public class Operator {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public static int operate(int left, int right, String operator) {
        if (operator.equals(PLUS)) {
            return plus(left, right);
        } else if (operator.equals(MINUS)) {
            return minus(left, right);
        } else if (operator.equals(MULTIPLY)) {
            return multiply(left, right);
        } else if (operator.equals(DIVIDE)) {
            return divide(left, right);
        }
        return 0;
    }

    public static int plus(int left, int right) {
        return left + right;
    }

    public static int minus(int left, int right) {
        return left - right;
    }

    public static int multiply(int left, int right) {
        return left * right;
    }

    public static int divide(int left, int right) {
        return left / right;
    }
}
