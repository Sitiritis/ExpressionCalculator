package ExpressionCalculator;

public class Greater extends Relation
{
  public Greater(Expression left, Expression right)
  {
    super((left.getResult() > right.getResult()) ? 1 : 0, left, right);
  }
}
