package Calculator;

import Calculator.dto.ExpressionDto;
import Calculator.dto.ResultDto;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.IO.SystemOutputHandler;
import Calculator.handler.calculate.ArithmeticCalculateHandler;
import Calculator.handler.calculate.CalculateHandler;
import Calculator.handler.calculate.DequeExpressionIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator;
    CalculateHandler calculateHandler = new ArithmeticCalculateHandler(new DequeExpressionIterator());
    TestSystemInputHandler inputHandler = new TestSystemInputHandler();
    OutputHandler outputHandler = new SystemOutputHandler();

    @BeforeEach
    public void initCalculator() {
        calculator = new Calculator(inputHandler, outputHandler, calculateHandler);
    }

    @Nested
    @DisplayName("input 테스트")
    class TestA {

        @Test
        @DisplayName("1 + 2 - 3 / 4 * 5 가 입력된 경우")
        void inputTest() {
            String input = "1 + 2 - 3 / 4 * 5";
            inputHandler.setScanner(input);

            ExpressionDto dto = calculator.inputExpression();

            assertThat(dto.getExpression()).isEqualTo("1 + 2 - 3 / 4 * 5");
        }
    }

    @Nested
    @DisplayName("calculate 테스트")
    class TestB {

        @Test
        @DisplayName("1 + 2 * 3 - 4 / 5 = 1")
        void calculateTest1() {
            String input = "1 + 2 * 3 - 4 / 5";
            inputHandler.setScanner(input);

            ExpressionDto dto = calculator.inputExpression();
            ResultDto calculate = calculator.calculate(dto);

            assertThat(calculate.getResult()).isEqualTo(1);
        }

        @Test
        @DisplayName("2 + 3 * 4 / 2 = 10")
        void calculateTest2() {
            String input = "2 + 3 * 4 / 2";
            inputHandler.setScanner(input);

            ExpressionDto dto = calculator.inputExpression();
            ResultDto calculate = calculator.calculate(dto);

            assertThat(calculate.getResult()).isEqualTo(10);
        }
    }

    @Nested
    @DisplayName("output 테스트")
    class TestC {

        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        @DisplayName("1 + 2 * 3 - 4 / 5 = 1 결과 출력")
        void outputTest1() {
            String input = "1 + 2 * 3 - 4 / 5";
            inputHandler.setScanner(input);

            ExpressionDto dto = calculator.inputExpression();
            ResultDto resultDto = calculator.calculate(dto);
            calculator.printResult(resultDto);

            assertThat(outputStream.toString().trim()).isEqualTo("1 + 2 * 3 - 4 / 5 = 1");
        }

        @Test
        @DisplayName("2 + 3 * 4 / 2 = 10 결과 출력")
        void outputTest2() {
            String input = "2 + 3 * 4 / 2";
            inputHandler.setScanner(input);

            ExpressionDto dto = calculator.inputExpression();
            ResultDto resultDto = calculator.calculate(dto);
            calculator.printResult(resultDto);

            assertThat(outputStream.toString().trim()).isEqualTo("2 + 3 * 4 / 2 = 10");
        }
    }
}