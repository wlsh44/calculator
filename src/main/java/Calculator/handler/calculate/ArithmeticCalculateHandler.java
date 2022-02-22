package Calculator.handler.calculate;

import Calculator.operator.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

import static Calculator.handler.calculate.CalculateUtil.isDigit;
import static Calculator.handler.calculate.CalculateUtil.isOperator;

public class ArithmeticCalculateHandler implements CalculateHandler {

    private Deque<Integer> numIter;
    private Deque<String> operatorIter;

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

    private void splitExpression(String expression) {
        String[] split = expression.split(" ");

        numIter = extractNumIter(split);
        operatorIter = extractOperatorIter(split);
    }

    private Deque<Integer> extractNumIter(String[] split) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String s : split) {
            if (isDigit(s)) {
                deque.add(Integer.parseInt(s));
            }
        }
        return deque;
    }

    private Deque<String> extractOperatorIter(String[] split) {
        Deque<String> deque = new ArrayDeque<>();

        for (String s : split) {
            if (isOperator(s)) {
                deque.add(s);
            }
        }
        return deque;
    }
}
