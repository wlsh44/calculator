package Calculator.operator.operators;

import Calculator.operator.Operator;

public class Plus extends Operator {

    @Override
    public int operate(int left, int right) {
        return left + right;
    }
}
