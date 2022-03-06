package Calculator.handler.calculate;

import Calculator.exception.InvalidExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DequeExpressionIteratorTest {

    private final ExpressionIterator iterator = new DequeExpressionIterator();

    @Nested
    @DisplayName("기본 기능 테스트")
    class TestA {

        @Test
        @DisplayName("push back 테스트1")
        void basicTest1() {
            iterator.pushNumBack(1);

            assertThat(iterator.numIterSize()).isEqualTo(1);
        }

        @Test
        @DisplayName("push back 테스트2")
        void basicTest2() {
            iterator.pushNumBack(1);
            iterator.pushNumBack(2);

            assertThat(iterator.numIterSize()).isEqualTo(2);
        }

        @Test
        @DisplayName("pop front 테스트1")
        void basicTest3() {
            iterator.pushNumBack(1);

            assertThat(iterator.popNumFront()).isEqualTo(1);
        }

        @Test
        @DisplayName("pop front 테스트2")
        void basicTest4() {
            iterator.pushNumBack(1);
            iterator.pushNumBack(2);

            assertThat(iterator.popNumFront()).isEqualTo(2);
            assertThat(iterator.popNumFront()).isEqualTo(1);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("expression 파싱 테스트")
    class TestB {
        private Stream<Arguments> provideValidSplitExpression() {
            return Stream.of(
                    Arguments.of("1 + 0 - 10 * 5 / 9", "[1, 0, 10, 5, 9]\n[PLUS, MINUS, MULTIPLY, DIVIDE]"),
                    Arguments.of("1 + 2 - 3 / 4 * 5", "[1, 2, 3, 4, 5]\n[PLUS, MINUS, DIVIDE, MULTIPLY]")
            );
        }

        @ParameterizedTest(name = "{index} => {0} = {1}")
        @MethodSource("provideValidSplitExpression")
        @DisplayName("올바른 파싱")
        void splitExpressionTest(String expression, String expected) {
            String res = iterator.splitExpression(expression);

            assertThat(res).isEqualTo(expected);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        @DisplayName("null 값 입력")
        void invalidExpressionTest() {
            String expression = null;
            Exception exception = assertThrows(NullPointerException.class, () -> iterator.splitExpression(expression));

            String expected = "null 값 입력";

            assertThat(exception.getMessage()).isEqualTo(expected);
        }

        private Stream<Arguments> provideInvalidSplitExpression() {
            return Stream.of(
                    Arguments.of(null, new NullPointerException("null 값 입력")),
                    Arguments.of(" ", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1 + 1 1 - 2 / 4", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1+ 2 - 3", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1 +2 - 3", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1a + 2 - 3", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1 + 2a - 3", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1 + 2 - 3 /", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1 Q 2 - 3", new InvalidExpressionException("올바르지 않은 수식")),
                    Arguments.of("1 + * - 3", new InvalidExpressionException("올바르지 않은 수식"))
            );
        }

        @ParameterizedTest(name = "{index} => {0} = {1}")
        @MethodSource("provideInvalidSplitExpression")
        @DisplayName("올바르지 않은 수식")
        void invalidExpressionTest2(String expression, Exception expected) {
            Exception exception = assertThrows(InvalidExpressionException.class, () -> iterator.splitExpression(expression));

            assertThat(exception.getMessage()).isEqualTo(expected.getMessage());
        }
    }
}