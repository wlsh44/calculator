package Calculator.handler.calculate;

import Calculator.operator.Operator;

public interface ExpressionIterator {
    int popNumFront();
    boolean hasNextOperator();
    Operator popOperatorFront();
    void pushNumBack(int num);
    void pushOperatorBack(Operator operator);
    String splitExpression(String expression);
    int numIterSize();
    int operatorIterSize();
}
