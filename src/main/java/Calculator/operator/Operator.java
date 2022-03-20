package Calculator.operator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    private static final Map<String, String> matcher = Collections
            .unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Operator::symbol, Operator::name)));

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public int operate(int left, int right) {
        return expression.apply(left, right);
    }

    public String symbol() {
        return this.symbol;
    }

    public static Operator of(String symbol) {
        return Operator.valueOf(matcher.get(symbol));
    }
}
