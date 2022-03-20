package Calculator.dto;

public class InvalidResultDto implements ResultDto {

    private final String errorMsg;

    public InvalidResultDto(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return errorMsg;
    }
}
