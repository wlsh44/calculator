package Calculator.handler.calculate;

import Calculator.operator.Operator;

public interface ExpressionIterator {
    int popNumFront();
    boolean hasNextOperator();
    Operator popOperatorFront();
    void pushNumBack(int num);
    void pushOperatorBack(Operator operator);
    void splitExpression(String expression);
}
