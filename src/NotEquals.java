package ExpressionCalculator;

public class NotEquals extends Relation
{
  public NotEquals(Expression left, Expression right)
  {
    super(left, right);
  }

  @Override
  public int calculate()
  {
    return left.calculate() != right.calculate() ? 1 : 0 ;
  }
}
