package Calculator.handler.calculate;

import Calculator.operator.Operator;
import Calculator.exception.InvalidExpressionException;

import java.util.ArrayDeque;
import java.util.Deque;

import static Calculator.util.CalculateUtil.isDigit;
import static Calculator.util.CalculateUtil.isOperator;

public class DequeExpressionIterator implements ExpressionIterator {

    private Deque<Integer> numIter;
    private Deque<Operator> operatorIter;

    public DequeExpressionIterator() {
        numIter = new ArrayDeque<>();
        operatorIter = new ArrayDeque<>();
    }

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
    public int numIterSize() {
        return numIter.size();
    }

    @Override
    public int operatorIterSize() {
        return operatorIter.size();
    }

    @Override
    public String splitExpression(String expression) {
        if (expression == null) {
            throw new InvalidExpressionException("null 값 입력");
        }
        String[] split = expression.split(" ");
        if (split.length == 0) {
            throw new InvalidExpressionException();
        } else if (split.length % 2 == 0) {
            throw new InvalidExpressionException();
        }

        numIter = parseNumIter(split);
        operatorIter = parseOperatorIter(split);

        return numIter.toString() + "\n" + operatorIter.toString();
    }

    private Deque<Integer> parseNumIter(String[] split) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < split.length; i+=2) {
            if (!isDigit(split[i])) {
                throw new InvalidExpressionException();
            }
            deque.add(Integer.parseInt(split[i]));
        }
        return deque;
    }

    private Deque<Operator> parseOperatorIter(String[] split) {
        Deque<Operator> deque = new ArrayDeque<>();

        for (int i = 1; i < split.length; i+=2) {
            if (!isOperator(split[i])) {
                throw new InvalidExpressionException();
            }
            deque.add(Operator.of(split[i]));
        }

        return deque;
    }
}
