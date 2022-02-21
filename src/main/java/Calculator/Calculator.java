package Calculator;

public class Calculator {

    private String expression;
    private final InputHandler inputHandler;
    private final CalculateHandler calculateHandler;

    public Calculator(InputHandler inputHandler, CalculateHandler calculateHandler) {
        this.inputHandler = inputHandler;
        this.calculateHandler = calculateHandler;
    }

    public String inputExpression() {
        expression = inputHandler.inputData();
        
        return expression;
    }

    public int calculate() {
        return calculateHandler.calculate(expression);
    }
}
