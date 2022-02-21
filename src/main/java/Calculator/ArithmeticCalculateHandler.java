package Calculator;

import java.util.ArrayDeque;

public class ArithmeticCalculateHandler implements CalculateHandler {

    private final ArrayDeque<Integer> numIter = new ArrayDeque<>();
    private final ArrayDeque<String> operatorIter = new ArrayDeque<>();

    @Override
    public int calculate(String expression) {
        splitExpression(expression);
        for (String operator : operatorIter) {
            int leftNum = numIter.poll();
            int rightNum = numIter.poll();

            switch (operator) {
                case Operator.PLUS -> numIter.addFirst(leftNum + rightNum);
                case Operator.MINUS -> numIter.addFirst(leftNum - rightNum);
                case Operator.MULTIPLY -> numIter.addFirst(leftNum * rightNum);
                case Operator.DIVIDE -> numIter.addFirst(leftNum / rightNum);
            }
        }
        return numIter.poll();
    }

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
