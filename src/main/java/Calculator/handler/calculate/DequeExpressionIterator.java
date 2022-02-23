package Calculator.handler.calculate;

import Calculator.operator.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

import static Calculator.handler.calculate.CalculateUtil.isDigit;
import static Calculator.handler.calculate.CalculateUtil.isOperator;

public class DequeExpressionIterator implements ExpressionIterator {

    private Deque<Integer> numIter;
    private Deque<Operator> operatorIter;

    @Override
    public int popNumFront() {
        return numIter.poll();
    }

    @Override
    public boolean hasNextOperator() {
        return !operatorIter.isEmpty();
    }

    @Override
    public Operator popOperatorFront() {
        return operatorIter.poll();
    }

    @Override
    public void pushNumBack(int num) {
        numIter.addFirst(num);
    }

    @Override
    public void pushOperatorBack(Operator operator) {
        operatorIter.addFirst(operator);
    }

    @Override
    public void splitExpression(String expression) {
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

    private Deque<Operator> extractOperatorIter(String[] split) {
        Deque<Operator> deque = new ArrayDeque<>();

        for (String s : split) {
            if (isOperator(s)) {
                deque.add(Operator.getEnumByOperator(s));
            }
        }
        return deque;
    }
}
