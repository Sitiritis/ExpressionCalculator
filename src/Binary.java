package ExpressionCalculator;

public class Binary extends Expression
{
  public Binary(int result, Expression left, Expression right)
  {
    super(result);
    this.left = left;
    this.right = right;
  }

  private Expression left;
  private Expression right;
}
