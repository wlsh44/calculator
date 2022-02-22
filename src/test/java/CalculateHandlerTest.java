import Calculator.handler.calculate.CalculateHandler;
import Calculator.handler.calculate.ArithmeticCalculateHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateHandlerTest {

    private final CalculateHandler calculateHandler = new ArithmeticCalculateHandler();

    @Test
    @DisplayName("1 + 2 * 3 - 4 / 5 = 1")
    void calculate_test1() {
        String expression = "1 + 2 * 3 - 4 / 5";

        int res = calculateHandler.calculate(expression);

        assertThat(res).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 = 10")
    void calculate_test2() {
        String expression = "2 + 3 * 4 / 2";

        int res = calculateHandler.calculate(expression);

        assertThat(res).isEqualTo(10);
    }

    @Test
    @DisplayName("1 + 0 - 10 * 5 / 9 = -5")
    void calculate_test3() {
        String expression = "1 + 0 - 10 * 5 / 9";

        int res = calculateHandler.calculate(expression);

        assertThat(res).isEqualTo(-5);
    }

    @Test
    @DisplayName("10 + 20 * 30 - 40 / 10 = 86")
    void calculate_test4() {
        String expression = "10 + 20 * 30 - 40 / 10";

        int res = calculateHandler.calculate(expression);

        assertThat(res).isEqualTo(86);
    }
}
