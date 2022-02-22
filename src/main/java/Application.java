import Calculator.*;
import Calculator.handler.IO.InputHandler;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.IO.SystemInputHandler;
import Calculator.handler.IO.SystemOutputHandler;
import Calculator.handler.calculate.ArithmeticCalculateHandler;
import Calculator.handler.calculate.CalculateHandler;

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
