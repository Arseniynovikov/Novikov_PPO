package com.example.lr_3.calculator.tokenizer;

import com.example.lr_3.calculator.operator.Operator;
/**
 * Represents an operator used in expressions
 */
public class OperatorToken extends Token {
    private final Operator operator;

    /**
     * Create a new instance
     *
     * @param op the operator
     */
    public OperatorToken(Operator op) {
        super(Token.TOKEN_OPERATOR);
        if (op == null) {
            throw new IllegalArgumentException("Operator is unknown for token.");
        }
        this.operator = op;
    }

    /**
     * Get the operator for that token
     *
     * @return the operator
     */
    public Operator getOperator() {
        return operator;
    }
}
