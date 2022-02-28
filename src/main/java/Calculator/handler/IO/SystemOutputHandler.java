package Calculator.handler.IO;

import Calculator.dto.ResultDto;

public class SystemOutputHandler implements OutputHandler {

    @Override
    public void printResult(ResultDto dto) {
        System.out.println(dto.toString());
    }
}
