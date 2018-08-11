package ExpressionCalculator;

public class Multiply extends Factor
{
  public Multiply(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() * right.calculate();
  }
}
