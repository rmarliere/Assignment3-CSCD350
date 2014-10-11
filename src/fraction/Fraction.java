package fraction;

/**
 * Author: Rodrigo Marliere
 * Revision date: 10/10/14
 * Assignment: Assignment 3
 * Class: CSCD 350
 */

import java.math.BigInteger;

public class Fraction
{
	private int num;
	private int den;
	
	private int gcd;
	private double value;
		
	public Fraction(int num, int den)
	{
		int gcd = calculateGcd(num, den);
		setGcd(gcd);
		if ((num < 0 && den < 0) || (num > 0 && den < 0))
		{
			num = num * -1;
			den = den * -1;
		}
		this.setNum(num);
		this.setDen(den);
		
		double value = getNum() / (double) getDen();
		this.setValue(value);
		
	}
	
	public int compareTo(Fraction fraction)
	{
		if (this.getValue() > fraction.getValue())
		{
			return 2;
		}
		else if (this.getValue() < fraction.getValue())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public Boolean equals(Fraction fraction)
	{
		if (fraction.num == this.num && fraction.den == this.den)
		{
			return true;
		}
		return false;
	}
	
	public Fraction multiply(Fraction fraction)
	{
		if (fraction == null)
			throw new NullPointerException("Cannot perform math operations on a null fraction object!");
		
		int num = (this.num * fraction.num);
		int den = (this.den * fraction.den);
		
		fraction = new Fraction(num, den);
		
		return fraction;
	}
	
	public Fraction add(Fraction fraction)
	{
		if (fraction == null)
			throw new NullPointerException("Cannot perform math operations on a null fraction object!");
		
		int lcm = calculateLcm(this.getDen(), fraction.getDen());
		int num = (lcm/this.getDen())*this.getNum() + (lcm/fraction.getDen())*fraction.getNum();
		int den = lcm;
		
		fraction = new Fraction(num, den);
		
		return fraction;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(getNum()) + "/" + String.valueOf(getDen());
	}
	

	private int calculateGcd(int num, int den)
	{
		BigInteger i1 = new BigInteger(String.valueOf(num));
	    BigInteger i2 = new BigInteger(String.valueOf(den));
	    
	    BigInteger gcd = i1.gcd(i2);
	    return gcd.intValue();
	}
	
	private int calculateLcm(int den1, int den2) {
		return (den1 * den2) / calculateGcd(den1, den2);
	}
	
	public double realValue()
	{
		return this.getValue();
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num/ getGcd();
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		if (den == 0)
			throw new IllegalArgumentException("The denominator with the value of 0 is not permitted");
		
		this.den = den / getGcd();
	}
	
	private int getGcd()
	{
		return this.gcd;
	}
	
	private void setGcd(int gcd)
	{
		this.gcd = gcd;
	}

	private double getValue() {
		return value;
	}

	private void setValue(double value) {
		this.value = value;
	}

}
