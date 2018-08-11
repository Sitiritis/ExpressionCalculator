package ExpressionCalculator;

public class LessOrEqual extends Relation
{
  public LessOrEqual(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() <= right.calculate() ? 1 : 0 ;
  }
}
