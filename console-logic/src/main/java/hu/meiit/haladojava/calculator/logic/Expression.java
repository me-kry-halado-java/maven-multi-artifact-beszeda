package hu.meiit.haladojava.calculator.logic;

public class Expression {

    private final double operand1;
    private final String operator;
    private final double operand2;


    public Expression(double operand1, String operator, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public String getOperator() {
        return operator;
    }
}