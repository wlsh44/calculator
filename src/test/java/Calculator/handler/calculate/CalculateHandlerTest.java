package Calculator.handler.calculate;

import exception.CalculateException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateHandlerTest {

    private final CalculateHandler calculateHandler = new ArithmeticCalculateHandler(new DequeExpressionIterator());

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class CalculateTest {
        private Stream<Arguments> provideCalculateTest() {
            return Stream.of(
                    Arguments.of("1 + 2 * 3 - 4 / 5", 1),
                    Arguments.of("2 + 3 * 4 / 2", 10),
                    Arguments.of("1 + 0 - 10 * 5 / 9", -5),
                    Arguments.of("10 + 20 * 30 - 40 / 10", 86),
                    Arguments.of("1", 1)
            );
        }

        @ParameterizedTest(name = "{index} => {0} = {1}")
        @MethodSource("provideCalculateTest")
        void calculateTest(String expression, int expected) {
            int res = calculateHandler.calculate(expression);

            assertThat(res).isEqualTo(expected);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class ExceptionTest {
        private Stream<Arguments> provideCalculateTest() {
            return Stream.of(
                    Arguments.of("1 + 2 * 3 - 4 / 2", new CalculateException("나누어지지 않는 값")),
                    Arguments.of("2 + 3 * 4 / 0", new CalculateException("나누어지지 않는 값"))
            );
        }

        @ParameterizedTest(name = "{index} => {0} = {1}")
        @MethodSource("provideCalculateTest")
        void calculateTest(String expression, Exception expected) {
            Exception exception = assertThrows(CalculateException.class, () -> calculateHandler.calculate(expression));

            assertThat(exception.getMessage()).isEqualTo(expected.getMessage());
        }
    }
}
