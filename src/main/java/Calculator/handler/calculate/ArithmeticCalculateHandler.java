package Calculator.handler.calculate;

import Calculator.exception.CalculateException;
import Calculator.operator.Operator;

import static Calculator.operator.Operator.DIVIDE;

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
            if (DIVIDE.equals(operator) && isExceptionCase(leftNum, rightNum)) {
                throw new CalculateException("나누어지지 않는 값");
            }
            int res = operator.operate(leftNum, rightNum);

            iterator.pushNumBack(res);
        }
        return iterator.popNumFront();
    }

    private boolean isExceptionCase(int leftNum, int rightNum) {
        return (rightNum == 0) || (leftNum % rightNum != 0);
    }
}
