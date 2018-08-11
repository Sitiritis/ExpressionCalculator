package ExpressionCalculator;

public class Binary extends Expression
{
  public Binary(Expression left, Expression right)
  {
    this.left = left;
    this.right = right;
  }

  protected Expression left;
  protected Expression right;
}
