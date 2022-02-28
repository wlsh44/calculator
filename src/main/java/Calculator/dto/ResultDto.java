package Calculator.dto;

public class ResultDto {

	private String expression;
	private int result;

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
}
