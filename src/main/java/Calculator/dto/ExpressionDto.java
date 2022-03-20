package Calculator.dto;

public class ExpressionDto {

    private final String expression;

    public ExpressionDto(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
