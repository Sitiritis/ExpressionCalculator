package ExpressionCalculator;

public class Multiply extends Factor
{
  public Multiply(Expression left, Expression right)
  {
    super(left.getResult() * right.getResult(), left, right);
  }
}
