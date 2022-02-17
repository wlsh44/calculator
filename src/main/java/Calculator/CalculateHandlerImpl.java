package Calculator;

import java.util.ArrayDeque;
import java.util.function.Consumer;

public class CalculateHandlerImpl implements CalculateHandler {

    private final ArrayDeque<Integer> numIter = new ArrayDeque<>();
    private final ArrayDeque<String> operatorIter = new ArrayDeque<>();

    @Override
    public int calculate() {
        return 0;
    }

    @Override
    public void splitExpression(String expression) {
        for (String s : expression.split(" ")) {
            if (isDigit(s)) {
                numIter.add(Integer.valueOf(s));
            } else {
                operatorIter.add(s);
            }
        }
    }

    private boolean isDigit(String s) {
        for (Character c : s.toCharArray()) {
            if (!('0' <= c && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}
