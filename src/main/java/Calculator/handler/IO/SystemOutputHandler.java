package Calculator.handler.IO;

public class SystemOutputHandler implements OutputHandler {

    @Override
    public String printResult(int result) {
        String res = "result = " + result;

        System.out.println(res);
        return res;
    }
}
