package ExpressionCalculator;

public class IntExpr extends Unary
{
  int result;

  public IntExpr(int res)
  {
    result = res;
  }

  @Override
  public int calculate()
  {
    return result;
  }
}
