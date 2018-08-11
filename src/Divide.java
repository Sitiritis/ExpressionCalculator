package ExpressionCalculator;

public class Divide extends Factor
{
  public Divide(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() / right.calculate();
  }
}
