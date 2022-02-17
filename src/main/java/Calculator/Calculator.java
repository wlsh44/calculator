package Calculator;

public class Calculator {

    private String expression;
    private InputHandler inputHandler;

    public Calculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public int calculate() {
        expression = inputHandler.inputData();

        return 0;
    }
}
