package Calculator.handler.calculate;

import Calculator.operator.Operator;

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
