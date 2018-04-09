package de.allianz.apkv.calculator;

/**
 *
 * This is an abstract class which defines the 4 basic arithmetic operations for numeric data types.
 * The supported operations are - ADD, SUBTRACT, MULTIPLY and DIVIDE 
 *
 * @author Deepa
 * @version 0.1
 * @since 5th Apr 2016
 */

public abstract class Calculator<T1 extends Number,T2 extends Number>
{
	private T1 operand1;
	private T2 operand2;	
	private double result;
	
	/* Constructor */
	public Calculator(T1 op1,T2 op2)
	{
		operand1 = op1;
		operand2 = op2;
		result   = 0.0;
	}
	
	/* Set operand1 */
	public void setOperand1(T1 operand1) {
		this.operand1 = operand1;
	}

	/* Set operand2 */
	public void setOperand2(T2 operand2) {
		this.operand2 = operand2;
	}

	/* Set result */
	public void setResult(double result) {
		this.result = result;
	}

	/* Get result  */
	public double getResult() {
		return result;
	}

	/* Get operand1 */
	public T1 getOperand1() {
		return operand1;
	}

	/* Get operand2 */
	public T2 getOperand2() {
		return operand2;
	}

	
	@Override
	public boolean equals(Object obj)
	{
		boolean res=false;
		@SuppressWarnings("unchecked")
		Calculator<T1,T2> cobj = (Calculator<T1,T2>) obj;
		if (this.operand1 == cobj.operand1 && this.operand2 == cobj.operand2 
			&& this.result == cobj.result)
		{
			res = true;
		}
		return res;
	}		
	
	public void displayCalculation(char op)
	{
		System.out.println("Calculation :"+operand1+op+operand2+" = "+result);
	}
	
	public abstract void add();
	public abstract void subtract();
	public abstract void multiply();
	public abstract void divide() ;

	
}


