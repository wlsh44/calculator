package Calculator.handler.calculate;

import Calculator.operator.Operator;
import Calculator.exception.CalculateException;

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
            if (operator.equals(Operator.DIVIDE) && isExceptionCase(leftNum, rightNum)) {
                throw new CalculateException("나누어지지 않는 값");
            }
            int res = operator.operate(leftNum, rightNum);

            iterator.pushNumBack(res);
        }
        return iterator.popNumFront();
    }

    private boolean isExceptionCase(int leftNum, int rightNum) {
        if (rightNum == 0) {
            return true;
        } else if (leftNum % rightNum != 0) {
            return true;
        }
        return false;
    }
}
