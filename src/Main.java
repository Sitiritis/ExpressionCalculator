package ExpressionCalculator;

public class Main
{
  public static void main(String[] args)
  {
    ExpressionParser ep = new ExpressionParser("((((301 - 1) * 5) + 3) - 3) * 2 == 3000");
    System.out.println(ep.parse().getResult());
  }
}
