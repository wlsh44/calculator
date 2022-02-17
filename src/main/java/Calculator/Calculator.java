package Calculator;

public class Calculator {

    private String expression;
    private InputHandler inputHandler;
    private CalculateHandler calculateHandler;

    public Calculator(InputHandler inputHandler, CalculateHandler calculateHandler) {
        this.inputHandler = inputHandler;
        this.calculateHandler = calculateHandler;
    }

    public int calculate() {
        expression = inputHandler.inputData();
        calculateHandler.splitExpression(expression);
        return calculateHandler.calculate();
    }
}
