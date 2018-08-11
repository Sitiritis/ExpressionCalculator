package ExpressionCalculator;

public class GreaterOrEqual extends Relation
{
  public GreaterOrEqual(Expression left, Expression right)
  {
    super((left.getResult() >= right.getResult()) ? 1 : 0, left, right);
  }
}
