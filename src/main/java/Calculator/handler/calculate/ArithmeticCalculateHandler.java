package Calculator.handler.calculate;

import Calculator.operator.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

import static Calculator.handler.calculate.CalculateUtil.isDigit;
import static Calculator.handler.calculate.CalculateUtil.isOperator;

public class ArithmeticCalculateHandler implements CalculateHandler {

    private ExpressionIterator iterator;

    public ArithmeticCalculateHandler(ExpressionIterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public int calculate(String expression) {
        iterator.splitExpression(expression);

        while (iterator.hasNextOperator()) {
            Operator operator = iterator.popOperatorFront();
            int leftNum = iterator.popNumFront();
            int rightNum = iterator.popNumFront();
            int res = operator.operate(leftNum, rightNum);

            iterator.pushNumBack(res);
        }
        return iterator.popNumFront();
    }
}
