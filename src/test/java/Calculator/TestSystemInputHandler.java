package Calculator;

import Calculator.handler.IO.InputHandler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TestSystemInputHandler implements InputHandler {

    private Scanner scanner;

    @Override
    public String inputData() {
        return scanner.nextLine();
    }

    void setScanner(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
    }
}
