package Calculator.dto;

public class ResultDto {

    private final String expression;
    private final int result;

    public ResultDto(String expression, int result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }
}
