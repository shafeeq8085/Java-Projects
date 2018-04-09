package de.allianz.apkv.calculator;

/**
*
* This extends the abstract class Calculator and implements the arithmetic operation for Integer.
* The supported operations are - ADD, SUBTRACT, MULTIPLY and DIVIDE 
*
* @author Deepa
* @version 0.1
* @since 5th Apr 2016
*/

public class IntegerCalculator extends Calculator<Integer,Integer>
{
	public IntegerCalculator(int a,int b)
	{
		super(a,b);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub		
		setResult(getOperand1()+getOperand2());
	}

	@Override
	public void subtract() {
		// TODO Auto-generated method stub
		setResult(getOperand1()-getOperand2());	
	}

	@Override
	public void multiply() {
		// TODO Auto-generated method stub
		setResult(getOperand1()*getOperand2());	}

	@Override
	public void divide() {
		// TODO Auto-generated method stub
		try
		{
			setResult(getOperand1()/getOperand2());
		}catch(ArithmeticException e)
		{
			System.out.println("Arithmetic Exception caught :"+e.getMessage());
		}
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash =  (int) ( (3 * getOperand1()) + (5 * getOperand2()) + (7 * getResult()) );
		return hash;
	}
}