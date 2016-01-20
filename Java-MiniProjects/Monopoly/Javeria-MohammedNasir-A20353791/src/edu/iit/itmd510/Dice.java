package edu.iit.itmd510;

public class Dice {
	public static final int randomnum	= 6;
	public int dievalue;
	
	public Dice()
	{
		rolldice();
	}
	
	/**
	 * This method generate random die values.
	 * @return randomly generated die value
	 */
	public int rolldice()
	{
		return dievalue =  (int)(Math.random()*randomnum + 1);
	}

}
