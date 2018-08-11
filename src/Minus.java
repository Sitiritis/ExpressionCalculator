package ExpressionCalculator;

public class Minus extends Term
{
  public Minus(Expression left, Expression right)
  {
    super(left.getResult() - right.getResult(), left, right);
  }
}
