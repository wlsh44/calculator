package Calculator;

import java.util.Scanner;

public class InputHandlerImpl implements InputHandler {

    @Override
    public String inputData() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
