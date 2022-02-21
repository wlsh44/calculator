package Calculator;

import java.util.ArrayDeque;

import static Calculator.CalculateUtil.isDigit;

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
}
