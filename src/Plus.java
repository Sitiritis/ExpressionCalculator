package ExpressionCalculator;

public class Plus extends Term
{
  public Plus(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() + right.calculate();
  }
}
