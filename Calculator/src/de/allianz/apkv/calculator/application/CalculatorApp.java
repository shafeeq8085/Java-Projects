package de.allianz.apkv.calculator.application;

import de.allianz.apkv.calculator.Calculator;
import de.allianz.apkv.calculator.DoubleCalculator;
import de.allianz.apkv.calculator.IntegerCalculator;

/**
 *
 * This is the main class to invoke the calculator 
 *
 * @author Deepa
 * @version 0.1
 * @since 5th Apr 2016
 */

public class CalculatorApp 
{
	public static void main(String args[])
	{
		Calculator<Integer,Integer> cintobj = new IntegerCalculator (20, 10);
		cintobj.add();
		cintobj.displayCalculation('+');
		cintobj.subtract();
		cintobj.displayCalculation('-');
		cintobj.multiply();
		cintobj.displayCalculation('x');
		cintobj.divide();
		cintobj.displayCalculation('/');
		
		Calculator<Double,Double> cdblobj = new DoubleCalculator (20.5, 10.5);
		cdblobj.add();
		cdblobj.displayCalculation('+');
		cdblobj.subtract();
		cdblobj.displayCalculation('-');
		cdblobj.multiply();
		cdblobj.displayCalculation('x');
		cdblobj.divide();
		cdblobj.displayCalculation('/');

	}
}


