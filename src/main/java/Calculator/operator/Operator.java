package Calculator.operator;

import Calculator.operator.operators.Divide;
import Calculator.operator.operators.Minus;
import Calculator.operator.operators.Multiply;
import Calculator.operator.operators.Plus;

public abstract class Operator {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public abstract int operate(int left, int right);

    public static Operator getOperatorObject(String operator) {
        switch (operator) {
            case PLUS -> {
                return new Plus();
            } case MINUS -> {
                return new Minus();
            } case MULTIPLY -> {
                return new Multiply();
            } case DIVIDE -> {
                return new Divide();
            }
        }
        return null;
    }
}
