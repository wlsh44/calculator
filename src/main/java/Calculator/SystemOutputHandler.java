package Calculator;

public class SystemOutputHandler implements OutputHandler {

    @Override
    public void printResult(int result) {
        System.out.println("result = " + result);
    }
}
