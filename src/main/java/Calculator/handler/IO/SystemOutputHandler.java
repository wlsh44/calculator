package Calculator.handler.IO;

import Calculator.dto.CalculatorDto;

public class SystemOutputHandler implements OutputHandler {

    @Override
    public String printResult(CalculatorDto dto) {
        String res = "result = " + dto.getResult();

        System.out.println(res);
        return res;
    }
}
