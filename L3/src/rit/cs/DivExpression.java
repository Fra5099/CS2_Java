package rit.cs;

/**
 * A class that implement Divide Expression
 * @author Faisal Alzahrany
 */
public class DivExpression implements Expression{
    private Expression left;
    private Expression right;

    public DivExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return this.left.evaluate()/this.right.evaluate();
    }

    @Override
    public String emit() {
        return "("+this.left.emit()+" / "+this.right.emit()+")";
    }
}
