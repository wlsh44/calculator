import Calculator.*;
import Calculator.dto.CalculatorDto;
import Calculator.handler.IO.InputHandler;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.IO.SystemInputHandler;
import Calculator.handler.IO.SystemOutputHandler;
import Calculator.handler.calculate.ArithmeticCalculateHandler;
import Calculator.handler.calculate.CalculateHandler;
import Calculator.handler.calculate.DequeExpressionIterator;

public class Application {
    public static void main(String[] args) {
        CalculateHandler calculateHandler = new ArithmeticCalculateHandler(new DequeExpressionIterator());
        InputHandler inputHandler = new SystemInputHandler();
        OutputHandler outputHandler = new SystemOutputHandler();
        Calculator calculator = new Calculator(inputHandler, outputHandler, calculateHandler);

        CalculatorDto dto = calculator.inputExpression();
        calculator.calculate(dto);
        calculator.printResult(dto);
    }
}
