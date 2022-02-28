package Calculator.handler.IO;

import Calculator.dto.ResultDto;

public class SystemOutputHandler implements OutputHandler {

    @Override
    public void printResult(ResultDto dto) {
        String res = dto.getExpression() + " = " + dto.getResult();

        System.out.println(res);
    }
}
