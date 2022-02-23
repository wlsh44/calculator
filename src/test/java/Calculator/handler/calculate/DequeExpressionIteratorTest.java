package Calculator.handler.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @Nested
    @DisplayName("expression 파싱 테스트")
    class TestB {

        @Test
        @DisplayName("expression 파싱1")
        void splitExpressionTest1() {
            String expression = "1 + 2 - 3 / 4 * 5";
            String expected = "[1, 2, 3, 4, 5]\n[PLUS, MINUS, DIVIDE, MULTIPLY]";

            String res = iterator.splitExpression(expression);

            assertThat(res).isEqualTo(expected);
        }

        @Test
        @DisplayName("expression 파싱2")
        void splitExpressionTest2() {
            String expression = "1 + 0 - 10 * 5 / 9";
            String expected = "[1, 0, 10, 5, 9]\n[PLUS, MINUS, MULTIPLY, DIVIDE]";

            String res = iterator.splitExpression(expression);

            assertThat(res).isEqualTo(expected);
        }
    }

}