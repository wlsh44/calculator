import Calculator.*;

public class Application {
    public static void main(String[] args) {
        CalculateHandler calculateHandler = new ArithmeticCalculateHandler();
        InputHandler inputHandler = new SystemInputHandler();
        OutputHandler outputHandler = new SystemOutputHandler();
        Calculator calculator = new Calculator(inputHandler, outputHandler, calculateHandler);

        calculator.inputExpression();
        calculator.calculate();
        calculator.printResult();
    }
}
