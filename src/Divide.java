package ExpressionCalculator;

public class Divide extends Factor
{
  public Divide(Expression left, Expression right)
  {
    super(left.getResult() / right.getResult(), left, right);
  }
}
