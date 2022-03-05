package Calculator.handler.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        private Stream<Arguments> provideSplitExpression() {
            return Stream.of(
                    Arguments.of("1 + 0 - 10 * 5 / 9", "[1, 0, 10, 5, 9]\n[PLUS, MINUS, MULTIPLY, DIVIDE]"),
                    Arguments.of("1 + 2 - 3 / 4 * 5", "[1, 2, 3, 4, 5]\n[PLUS, MINUS, DIVIDE, MULTIPLY]")
            );
        }

        @ParameterizedTest(name = "{index} => {0} = {1}")
        @MethodSource("provideSplitExpression")
        void splitExpressionTest(String expression, String expected) {
            String res = iterator.splitExpression(expression);

            assertThat(res).isEqualTo(expected);
        }
    }

}