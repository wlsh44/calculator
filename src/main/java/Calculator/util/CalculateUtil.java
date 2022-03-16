package Calculator.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Set<String> symbolSet = new HashSet<>(Arrays.asList(PLUS.symbol(), MINUS.symbol(), MULTIPLY.symbol(), DIVIDE.symbol()));
        return symbolSet.contains(s);
    }
}
