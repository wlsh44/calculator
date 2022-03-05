package Calculator;

import Calculator.dto.ExpressionDto;
import Calculator.dto.ResultDto;
import Calculator.dto.ValidResultDto;
import Calculator.handler.IO.OutputHandler;
import Calculator.handler.IO.SystemOutputHandler;
import Calculator.handler.calculate.ArithmeticCalculateHandler;
import Calculator.handler.calculate.CalculateHandler;
import Calculator.handler.calculate.DequeExpressionIterator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

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

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("calculate 테스트")
    class TestB {

        private Stream<Arguments> provideCalculateTest() {
            return Stream.of(
                    Arguments.of("1 + 2 * 3 - 4 / 5", 1),
                    Arguments.of("2 + 3 * 4 / 2", 10)
            );
        }

        @ParameterizedTest(name = "{index} => {0} = {1}")
        @MethodSource("provideCalculateTest")
        void calculateTest1(String input, int result) {
            inputHandler.setScanner(input);
            ResultDto expected = new ValidResultDto(input, result);

            ExpressionDto dto = calculator.inputExpression();
            ResultDto res = calculator.calculate(dto);

            assertThat(res).isEqualTo(expected);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("output 테스트")
    class TestC {

        private ByteArrayOutputStream outputStream;

        @BeforeEach
        public void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        private Stream<Arguments> provideOutputTest() {
            return Stream.of(
                    Arguments.of("1 + 2 * 3 - 4 / 5", "1 + 2 * 3 - 4 / 5 = 1"),
                    Arguments.of("2 + 3 * 4 / 2", "2 + 3 * 4 / 2 = 10")
            );
        }

        @ParameterizedTest(name = "{index} => {1}")
        @MethodSource("provideOutputTest")
        void outputTest(String input, String expected) {
            inputHandler.setScanner(input);

            ExpressionDto dto = calculator.inputExpression();
            ResultDto validResultDto = calculator.calculate(dto);
            calculator.printResult(validResultDto);

            assertThat(outputStream.toString().trim()).isEqualTo(expected);
        }
    }
}