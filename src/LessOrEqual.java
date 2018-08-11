package ExpressionCalculator;

public class LessOrEqual extends Relation
{
  public LessOrEqual(Expression left, Expression right)
  {
    super((left.getResult() <= right.getResult()) ? 1 : 0, left, right);
  }
}
