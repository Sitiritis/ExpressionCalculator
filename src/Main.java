package ExpressionCalculator;

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    Scanner inputScanner = new Scanner(System.in);

    System.out.println("Enter an expression:");
    String expr = inputScanner.nextLine();

    ExpressionParser ep = new ExpressionParser(expr);

    System.out.println("The result is");
    System.out.println(ep.parse().getResult()); // 1*9+2-(55<22*6)*2+34*1==(1==(1<4+(1>0)))
  }
}
