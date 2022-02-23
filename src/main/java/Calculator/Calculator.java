package Calculator;

import Calculator.handler.IO.InputHandler;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.calculate.CalculateHandler;

public class Calculator {

    private String expression;
    private int result;
    private final InputHandler inputHandler;
    private final CalculateHandler calculateHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, CalculateHandler calculateHandler) {
        this.inputHandler = inputHandler;
        this.calculateHandler = calculateHandler;
        this.outputHandler = outputHandler;
    }

    public String inputExpression() {
        expression = inputHandler.inputData();
        
        return expression;
    }

    public String printResult() {
        return outputHandler.printResult(result);
    }

    public int calculate() {
        result = calculateHandler.calculate(expression);

        return result;
    }
}
