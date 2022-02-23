package Calculator;

import Calculator.handler.IO.SystemInputHandler;
import Calculator.handler.IO.SystemOutputHandler;
import Calculator.handler.calculate.ArithmeticCalculateHandler;
import Calculator.handler.calculate.DequeExpressionIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator;

    public void initCalculator(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        calculator = new Calculator(new SystemInputHandler(), new SystemOutputHandler(), new ArithmeticCalculateHandler(new DequeExpressionIterator()));
    }

    @Nested
    @DisplayName("input 테스트")
    class TestA {

        @Test
        @DisplayName("1 + 2 - 3 / 4 * 5 가 입력된 경우")
        void inputTest() {
            String input = "1 + 2 - 3 / 4 * 5";
            initCalculator(input);

            String res = calculator.inputExpression();

            assertThat(res).isEqualTo("1 + 2 - 3 / 4 * 5");
        }
    }

    @Nested
    @DisplayName("calculate 테스트")
    class TestB {

        @Test
        @DisplayName("1 + 2 * 3 - 4 / 5 = 1")
        void calculateTest1() {
            String input = "1 + 2 * 3 - 4 / 5";
            initCalculator(input);

            calculator.inputExpression();
            int res = calculator.calculate();

            assertThat(res).isEqualTo(1);
        }

        @Test
        @DisplayName("2 + 3 * 4 / 2 = 10")
        void calculateTest2() {
            String input = "2 + 3 * 4 / 2";
            initCalculator(input);

            calculator.inputExpression();
            int res = calculator.calculate();

            assertThat(res).isEqualTo(10);
        }
    }

    @Nested
    @DisplayName("output 테스트")
    class TestC {

        @Test
        @DisplayName("1 + 2 * 3 - 4 / 5 = 1 결과 출력")
        void outputTest1() {
            String input = "1 + 2 * 3 - 4 / 5";
            initCalculator(input);

            calculator.inputExpression();
            calculator.calculate();
            String res = calculator.printResult();

            assertThat(res).isEqualTo("result = 1");
        }

        @Test
        @DisplayName("2 + 3 * 4 / 2 = 10 결과 출력")
        void outputTest2() {
            String input = "2 + 3 * 4 / 2";
            initCalculator(input);

            calculator.inputExpression();
            calculator.calculate();
            String res = calculator.printResult();

            assertThat(res).isEqualTo("result = 10");
        }
    }

}