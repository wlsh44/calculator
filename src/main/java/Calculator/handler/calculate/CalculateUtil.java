package Calculator.handler.calculate;

import static Calculator.operator.Operator.*;

public class CalculateUtil {

    public static boolean isDigit(String s) {
        for (Character c : s.toCharArray()) {
            if (!('0' <= c && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOperator(String s) {
        return s.equals(PLUS) || s.equals(MINUS) || s.equals(MULTIPLY) || s.equals(DIVIDE);
    }
}