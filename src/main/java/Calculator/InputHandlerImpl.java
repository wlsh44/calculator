package Calculator;

import java.util.Scanner;

public class InputHandlerImpl implements InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputData() {
        return scanner.nextLine();
    }
}
