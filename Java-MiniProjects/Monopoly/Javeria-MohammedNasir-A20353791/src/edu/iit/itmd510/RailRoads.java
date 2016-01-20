package edu.iit.itmd510;

public class RailRoads extends PropertySpaces {

	public int creditvalue;
	static int count = 0;
	
	/**
	 * This method uses static count  integer so that it keeps track of number of times the player 
	 * visited railroads in his play.Based on the count credit value is set.
	 * @param currentlocation
	 * @return creditvalue
	 */
	public int RailRoadCreditValue(String currentlocation)
	{
		count = count +1;
		if(count ==1)
		{			
		  creditvalue = count *200;
		  System.out.println(currentlocation + " awards " + "(" +count + " * " + "200 " + ")"+ " = "+creditvalue + " credits ");
		}
		
		if(count ==2)
		{
		  creditvalue = count * 200;
		  System.out.println(currentlocation + " awards " + "(" +count + " * " + "200 " + ")"+ " = "+creditvalue + " credits ");
		}
		if(count ==3)
		{
		  creditvalue = count*200;
		  System.out.println(currentlocation + " awards " + "(" +count + " * " + "200 " + ")"+ " = "+creditvalue + " credits ");
		}
		if(count ==4)
		{
		  creditvalue = count*200;
		  System.out.println(currentlocation + " awards " + "(" +count + " * " + "200 " + ")"+ " = "+creditvalue + " credits ");
		}
		
		return creditvalue;
	}
}
