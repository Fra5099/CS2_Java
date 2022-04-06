package rit.cs;

/**
 * A class that implement Multiply Expression
 * @author Faisal Alzahrany
 */

public class MulExpression implements Expression{
    private Expression left;
    private Expression right;

    public MulExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return this.left.evaluate()*this.right.evaluate();
    }

    @Override
    public String emit() {
        return "("+this.left.emit()+" * "+this.right.emit()+")";
    }

}

