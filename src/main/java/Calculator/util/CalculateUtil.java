package Calculator.util;

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
        return s.equals(PLUS.symbol()) || s.equals(MINUS.symbol()) ||
                s.equals(MULTIPLY.symbol()) || s.equals(DIVIDE.symbol());
    }
}
