package rit.cs;

/**
 * A class that implement Add Expression
 * @author Faisal Alzahrany
 */
public class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;

    }

    @Override
    public int evaluate() {
        return this.left.evaluate()+this.right.evaluate();
    }

    @Override
    public String emit() {
        return "("+this.left.emit()+" + "+this.right.emit()+")";
    }

}
