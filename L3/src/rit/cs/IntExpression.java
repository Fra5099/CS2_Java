package rit.cs;

/**
 * A class that get the value from string
 * @author Faisal Alzahrany
 */

public class IntExpression implements Expression {
    private int initVal;

    public IntExpression(int initVal) {
        this.initVal = initVal;
    }

    @Override
    public int evaluate() {
        return this.initVal;
    }

    @Override
    public String emit() {
        return String.valueOf(this.initVal);
    }
}
