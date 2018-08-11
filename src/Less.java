package ExpressionCalculator;

public class Less extends Relation
{
  public Less(Expression left, Expression right)
  {
    super((left.getResult() < right.getResult()) ? 1 : 0, left, right);
  }
}
