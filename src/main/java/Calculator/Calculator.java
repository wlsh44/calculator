package Calculator;

import Calculator.dto.ResultDto;
import Calculator.dto.ExpressionDto;
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

    public ExpressionDto inputExpression() {
        return new ExpressionDto(inputHandler.inputData());
    }

    public void printResult(ResultDto dto) {
        outputHandler.printResult(dto);
    }

    public ResultDto calculate(ExpressionDto dto) {
        int result = calculateHandler.calculate(dto.getExpression());
        ResultDto resultDto = new ResultDto(dto.getExpression(), result);

        return resultDto;
    }
}
