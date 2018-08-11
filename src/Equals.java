package ExpressionCalculator;

public class Equals extends Relation
{
  public Equals(Expression left, Expression right)
  {
    super((left.getResult() == right.getResult()) ? 1 : 0, left, right);
  }
}
