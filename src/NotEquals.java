package ExpressionCalculator;

public class NotEquals extends Relation
{
  public NotEquals(Expression left, Expression right)
  {
    super((left.getResult() != right.getResult()) ? 1 : 0, left, right);
  }
}
