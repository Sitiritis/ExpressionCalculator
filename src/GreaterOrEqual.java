package ExpressionCalculator;

public class GreaterOrEqual extends Relation
{
  public GreaterOrEqual(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() >= right.calculate() ? 1 : 0 ;
  }
}
