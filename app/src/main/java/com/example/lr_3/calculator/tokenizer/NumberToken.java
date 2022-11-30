package com.example.lr_3.calculator.tokenizer;

import java.math.BigDecimal;

/**
 * Represents a number in the expression
 */
public final class NumberToken extends Token {
    private final BigDecimal value;

    /**
     * Create a new instance
     *
     * @param value the value of the number
     */
    public NumberToken(BigDecimal value) {
        super(TOKEN_NUMBER);
        this.value = value;
    }

    NumberToken(final char[] expression, final int offset, final int len) {
        this(new BigDecimal(String.valueOf(expression, offset, len)));
    }

    /**
     * Get the value of the number
     *
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }
}
