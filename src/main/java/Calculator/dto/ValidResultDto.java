package Calculator.dto;

public class ValidResultDto implements ResultDto {

    private final String expression;
    private final int result;

    public ValidResultDto(String expression, int result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultDto)) {
            return false;
        }
        ValidResultDto dto = (ValidResultDto) obj;

        return expression.equals(dto.expression)
                && (result == dto.result);
    }
}
