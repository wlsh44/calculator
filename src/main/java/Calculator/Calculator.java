package Calculator;

import Calculator.dto.CalculatorDto;
import Calculator.handler.IO.InputHandler;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.calculate.CalculateHandler;

public class Calculator {

    private final InputHandler inputHandler;
    private final CalculateHandler calculateHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler, CalculateHandler calculateHandler) {
        this.inputHandler = inputHandler;
        this.calculateHandler = calculateHandler;
        this.outputHandler = outputHandler;
    }

    public CalculatorDto inputExpression() {
        CalculatorDto dto = new CalculatorDto();
        dto.setExpression(inputHandler.inputData());
        
        return dto;
    }

    public String printResult(CalculatorDto dto) {
        return outputHandler.printResult(dto);
    }

    public int calculate(CalculatorDto dto) {
        int result = calculateHandler.calculate(dto.getExpression());
        dto.setResult(result);

        return result;
    }
}
