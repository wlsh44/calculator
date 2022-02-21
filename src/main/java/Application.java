import Calculator.*;

public class Application {
    public static void main(String[] args) {
        CalculateHandler calculateHandler = new ArithmeticCalculateHandler();
        InputHandler inputHandler = new SystemInputHandler();
        Calculator calculator = new Calculator(inputHandler, calculateHandler);

        calculator.inputExpression();
        System.out.println(calculator.calculate());
    }
}
