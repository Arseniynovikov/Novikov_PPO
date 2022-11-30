package com.example.lr_3.calculator.function;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Class representing the builtin functions available for use in expressions
 */
public class Functions {

    private static final int INDEX_SIN = 0;
    private static final int INDEX_COS = 1;
    private static final int INDEX_TAN = 2;
    private static final int INDEX_COT = 3;
    private static final int INDEX_LOG = 4;
    private static final int INDEX_LOG10 = 5;
    private static final int INDEX_SQRT = 6;
    private static final int INDEX_POW = 7;
    private static final int INDEX_EXP = 8;


    private static final Function[] BUILT_IN_FUNCTIONS = new Function[9];

    static {
        BUILT_IN_FUNCTIONS[INDEX_SIN] = new Function("sin") {
            @Override
            public BigDecimal apply(BigDecimal... args) {
                return BigDecimal.valueOf(Math.sin(Double.parseDouble(args[0].toString())));
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_COS] = new Function("cos") {
            @Override
            public BigDecimal apply(BigDecimal... args) {
                return BigDecimal.valueOf(Math.cos(Double.parseDouble(args[0].toString())));
            }

        };
        BUILT_IN_FUNCTIONS[INDEX_TAN] = new

                Function("tan") {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        return BigDecimal.valueOf(Math.tan(Double.parseDouble(args[0].toString())));
                    }
                }

        ;
        BUILT_IN_FUNCTIONS[INDEX_COT] = new

                Function("cot") {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        BigDecimal tan = BigDecimal.valueOf(Math.tan(Double.parseDouble(args[0].toString())));
                        if (tan.equals(BigDecimal.valueOf(0d))) {
                            throw new ArithmeticException("Division by zero in cotangent!");
                        }
                        return BigDecimal.valueOf(1d).divide(tan, RoundingMode.CEILING);
                    }
                }

        ;
        BUILT_IN_FUNCTIONS[INDEX_LOG] = new

                Function("ln") {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        return BigDecimal.valueOf(Math.log(Double.parseDouble(args[0].toString())));
                    }
                }

        ;

        BUILT_IN_FUNCTIONS[INDEX_LOG10] = new

                Function("log") {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        return BigDecimal.valueOf(Math.log10(Double.parseDouble(args[0].toString())));
                    }
                }

        ;
        BUILT_IN_FUNCTIONS[INDEX_SQRT] = new

                Function("sqrt") {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        return BigDecimal.valueOf(Math.sqrt(Double.parseDouble(args[0].toString())));
                    }
                }

        ;
        BUILT_IN_FUNCTIONS[INDEX_POW] = new

                Function("pow", 2) {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        return args[0].pow(Integer.parseInt(args[1].toString()));}
                }

        ;
        BUILT_IN_FUNCTIONS[INDEX_EXP] = new

                Function("exp", 1) {
                    @Override
                    public BigDecimal apply(BigDecimal... args) {
                        return BigDecimal.valueOf(Math.exp(Integer.parseInt(args[0].toString())));
                    }
                };


    }

    /**
     * Get the builtin function for a given name
     *
     * @param name te name of the function
     * @return a Function instance
     */
    public static Function getBuiltinFunction(final String name) {

        switch (name) {
            case "sin":
                return BUILT_IN_FUNCTIONS[INDEX_SIN];
            case "cos":
                return BUILT_IN_FUNCTIONS[INDEX_COS];
            case "tan":
                return BUILT_IN_FUNCTIONS[INDEX_TAN];
            case "cot":
                return BUILT_IN_FUNCTIONS[INDEX_COT];
            case "ln":
                return BUILT_IN_FUNCTIONS[INDEX_LOG];
            case "log":
                return BUILT_IN_FUNCTIONS[INDEX_LOG10];
            case "sqrt":
                return BUILT_IN_FUNCTIONS[INDEX_SQRT];
            case "pow":
                return BUILT_IN_FUNCTIONS[INDEX_POW];
            case "exp":
                return BUILT_IN_FUNCTIONS[INDEX_EXP];
            default:
                return null;
        }
    }

}
