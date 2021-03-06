package hu.meiit.haladojava.calculator.console;

import java.util.Scanner;
import hu.meiit.haladojava.calculator.logic.Executor;
import hu.meiit.haladojava.calculator.logic.Expression;
public class App 
{
    private static final String errorResponse = "-";
    private static final int numberOfOperand = 3;

    private static String getExpressionFromStdin() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        return expression;
    }

    private static String[] parse(String expression) {
        String[] returnValue = new String[0];
        if (expression.length() > 3) {
            returnValue = expression.split(" ");
        } else if (expression.length() == 3) {
            returnValue = expression.split("");
        }
        return returnValue;
    }
    public static void assertExpression(String[] parts) throws Exception {
        if (parts.length != numberOfOperand) {
            throw new Exception("wrong input");
        }
    }

    private static Expression getAsExpression(String[] parts) {
        return new Expression(
                Integer.parseInt(parts[numberOfOperand - 3]),
                parts[numberOfOperand - 2],
                Integer.parseInt(parts[numberOfOperand - 1]));
    }
    public static String executeExpression(Expression expression) {
        Executor executor = new Executor();

        String result = errorResponse;
        if (expression.getOperator().equals("+")) {
            result = String.valueOf(executor.add(expression.getOperand1(), expression.getOperand2()));
        } else if (expression.getOperator().equals("-")) {
            result = String.valueOf(executor.sub(expression.getOperand1(), expression.getOperand2()));
        } else if (expression.getOperator().equals("/")) {
            if (expression.getOperand2() == 0) {
                result = "-";
            } else {
                result = String.valueOf(executor.div(expression.getOperand1(), expression.getOperand2()));
            }
        } else if (expression.getOperator().equals("*")) {
            result = String.valueOf(executor.multip(expression.getOperand1(), expression.getOperand2()));
        }
        return result;
    }


    ///main ///
    public static void main( String[] args )
    {
        String result = errorResponse;
        try {
            String exprFromStdin = getExpressionFromStdin();
            String[] parts = parse(exprFromStdin);
            assertExpression(parts);
            Expression expression = getAsExpression(parts);
            result = executeExpression(expression);
        } catch (Exception ex) {
        }
        System.out.print(result);


    }
}
