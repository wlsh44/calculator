package Calculator;

import Calculator.dto.InvalidResultDto;
import Calculator.dto.ResultDto;
import Calculator.dto.ValidResultDto;
import Calculator.dto.ExpressionDto;
import Calculator.handler.IO.InputHandler;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.calculate.CalculateHandler;
import exception.CalculateException;
import exception.InvalidExpressionException;

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
        try {
            int result = calculateHandler.calculate(dto.getExpression());
            ValidResultDto validResultDto = new ValidResultDto(dto.getExpression(), result);

            return validResultDto;
        } catch (CalculateException | InvalidExpressionException e) {
            return new InvalidResultDto(e.getMessage());
        }
    }
}
