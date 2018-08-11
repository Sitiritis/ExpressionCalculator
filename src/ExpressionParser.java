package ExpressionCalculator;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class ExpressionParser
{
  public ExpressionParser(String expressionToParse)
  {
    String trimmedStr = expressionToParse.replaceAll("\\s+", "");
    this.expressionToParse = trimmedStr;
    currentCharIndex = 0;
    currentCharNestLevel = 1;
  }

  public Expression parse()
  {
    ++nestLevel;
    Expression result = parseRelation();
    --nestLevel;

    return result;
  }

  private Expression parseRelation()
  {
    Expression result = parseTerm();
    int exprLen = expressionToParse.length();

    while (currentCharIndex < exprLen)
    {
      String operation = getNextOperation();

      if ((operation.equals("<")   ||
           operation.equals(">")   ||
           operation.equals("<=")  ||
           operation.equals(">=")  ||
           operation.equals("==")  ||
           operation.equals("!=")) &&
          currentCharNestLevel == nestLevel)
      {
        currentCharIndex += operation.length();

        Expression right = parseTerm();

        if (operation.equals("<"))
        {
          result = new Less(result, right);
        }
        else if (operation.equals(">"))
        {
          result = new Greater(result, right);
        }
        else if (operation.equals("<="))
        {
          result = new LessOrEqual(result, right);
        }
        else if (operation.equals(">="))
        {
          result = new GreaterOrEqual(result, right);
        }
        else if (operation.equals("=="))
        {
          result = new Equals(result, right);
        }
        else if (operation.equals("!="))
        {
          result = new Equals(result, right);
        }
      }
      else
      {
        break;
      }
    }

    return result;
  }

  private Expression parseTerm()
  {
    Expression result = parseFactor();
    int exprLen = expressionToParse.length();

    while (currentCharIndex < exprLen)
    {
      String operation = getNextOperation();

      if ((operation.equals("+")  ||
           operation.equals("-")) &&
           currentCharNestLevel == nestLevel)
      {
        currentCharIndex += operation.length();
        Expression right = parseFactor();

        if (operation.equals("+"))
        {
          result = new Plus(result, right);
        }
        else if (operation.equals("-"))
        {
          result = new Minus(result, right);
        }
      }
      else
      {
        break;
      }
    }

    return result;
  }

  private Expression parseFactor()
  {
    Expression result = parseUnary();
    int exprLen = expressionToParse.length();

    while (currentCharIndex < exprLen)
    {
      String operation = getNextOperation();

      if ((operation.equals("*") ||
           operation.equals("/")) &&
           currentCharNestLevel == nestLevel)
      {
        currentCharIndex += operation.length();

        Expression right = parseUnary();

        if (operation.equals("*"))
        {
          result = new Multiply(result, right);
        }
        else if (operation.equals("/"))
        {
          result = new Divide(result, right);
        }
      }
      else
      {
        break;
      }
    }

    return result;
  }

  private Expression parseUnary()
  {
    int exprLen = expressionToParse.length();

    while (currentCharIndex < exprLen)
    {
      char currentChar = expressionToParse.charAt(currentCharIndex);

      if (currentChar == '(')
      {
        ++currentCharIndex;
        ++currentCharNestLevel;
        return parse();
      }
      else
      {
        break;
      }
    }

    return parseInt();
  }

  private Expression parseInt()
  {
    int expressionLength = expressionToParse.length();
    char currentChar = expressionToParse.charAt(currentCharIndex);
    String number = new String();

    while ((currentChar == '0' ||
            currentChar == '1' ||
            currentChar == '2' ||
            currentChar == '3' ||
            currentChar == '4' ||
            currentChar == '5' ||
            currentChar == '6' ||
            currentChar == '7' ||
            currentChar == '8' ||
            currentChar == '9') &&
        currentCharIndex < expressionLength)
    {
      number += currentChar;

      if (++currentCharIndex < expressionLength)
      {
        currentChar = expressionToParse.charAt(currentCharIndex);
      }
    }

    return new IntExpr(Integer.parseInt(number));
  }

  private void SkipClosingParenth()
  {
    char currentChar = expressionToParse.charAt(currentCharIndex);
    int lastIndex = expressionToParse.length() - 1;

    while (currentChar == ')' && currentCharIndex < lastIndex)
    {
      currentChar = expressionToParse.charAt(++currentCharIndex);
      --currentCharNestLevel;
    }
  }

  private String getNextOperation()
  {
    SkipClosingParenth();

    String result = String.valueOf(expressionToParse.charAt(currentCharIndex++));

    if (currentCharIndex < expressionToParse.length())
    {
      char nextChar = expressionToParse.charAt(currentCharIndex);

      if (nextChar == '=')
      {
        result += nextChar;
      }

      --currentCharIndex;
    }


    return result;
  }

  private int currentCharNestLevel;
  private int nestLevel;
  private int currentCharIndex;
  private String expressionToParse;
}
