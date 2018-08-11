package ExpressionCalculator;

public class Plus extends Term
{
  public Plus(Expression left, Expression right)
  {
    super(left.getResult() + right.getResult(), left, right);
  }
}
