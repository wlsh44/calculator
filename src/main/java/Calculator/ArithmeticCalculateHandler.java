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
            int res = Operator.operate(leftNum, rightNum, operator);

            numIter.addFirst(res);
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
