package ExpressionCalculator;

public class Minus extends Term
{
  public Minus(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() - right.calculate();
  }
}
