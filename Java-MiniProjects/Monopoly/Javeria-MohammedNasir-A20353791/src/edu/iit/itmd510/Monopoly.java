package edu.iit.itmd510;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

/**
 * @author javeria
 *
 */
/**
 * @author javeria
 *
 */
/**
 * @author javeria
 *
 */
public class Monopoly {
	
	int totaldice, totalcreditvalue,RailRoadCreditvalue, Creditvalue=0;
	String CurrentLocation= "";
	static boolean bonusValue = true;
	
	/**
	 * This is the main method which has the implementation of all the finctionality of Monopoly game.
	 * This method starts with the 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monopoly argTest = new Monopoly();
		int total = 0 ;
		int pointer = 0;
		final int bonusCredit = 200;
		
        while (pointer <= 40 )
        {
            int totaldice = argTest.Check_Argument(args);
        	try 
        	{
				Thread.sleep(1000);
			} catch (InterruptedException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//Getting position of player
        	pointer = pointer + totaldice;
        	if (pointer < 40)
        	{
        		String currPos = argTest.getLocation(pointer);
        		//check for chance
        		if(currPos=="Chance")
        		{
        			String chancePos = null;
                	int chanceVal = argTest.RetrieveChanceCardsCreditValue(currPos);
                	
                	if(chanceVal==3)
                	{
                		pointer = pointer-3;
                		chancePos = argTest.getLocation(pointer);
                		int currPosVal = argTest.GetCreditValue(chancePos,pointer);
                		total = total + currPosVal;
                	}
                	
                	//Value 0 reserved for GOTOJAIL
                	else if(chanceVal==0)
                	{
                		// Force setting the position to jail
                		pointer = 10;
                		chancePos = argTest.getLocation(pointer);
                		bonusValue = argTest.goToJail(currPos);          		
                	}
                	else
                	{
                		//Adding Chance bonus
                		total = total + chanceVal;
                	}
                	
                	System.out.println("------------------------------------------------------");
                    System.out.println("TotalCredits : "+total);
                    System.out.println("CurrentPosition "+pointer);
                    System.out.println("");
                	continue;
                }
        		//Check for Community cards
        		if(currPos=="Community Chest")
        		{
        			String communityPos = null;
                	int communityVal = argTest.RetrieveCommunityCardsCreditValue(currPos);
                	
                	//Value 0 reserved for GOTOJAIL
                	if(communityVal==0)
                	{
                		// Force setting the position to jail
                		pointer = 10;
                		communityPos = argTest.getLocation(pointer);
                		bonusValue = argTest.goToJail(currPos); 		
                	}
                	else
                	{
                		//Adding Chance bonus
                		total = total + communityVal;
                	}
                	
                	System.out.println("------------------------------------------------------");
                    System.out.println("TotalCredits : "+total);
                    System.out.println("CurrentPosition "+pointer);
                    System.out.println("");
                	continue;
                }
        		
        		//Check for RailRoad
        		if(currPos =="Reading Railroad" || currPos =="Pennsylvania Railroad" || currPos =="B & O Railroad" || currPos =="Short Line Railroad")
        		{
                	int railRoadVal = argTest.GetRailRoadCreditValue(currPos);
                	total = total + railRoadVal;                	
                	System.out.println("------------------------------------------------------");
                    System.out.println("TotalCredits : "+total);
                    System.out.println("CurrentPosition "+pointer);
                    System.out.println("");
                	continue;
                }
        		
        		//check for GoToJail
        		if(currPos == "Go To Jail")
        		{
        			bonusValue = argTest.goToJail(currPos);
        			pointer = 10;
        		}
        		
	                int currPosVal = argTest.GetCreditValue(currPos,totaldice);
	                total = total + currPosVal;
	                System.out.println("------------------------------------------------------");
	                System.out.println("TotalCredits : "+total);
	                System.out.println("CurrentPosition "+pointer);
	                System.out.println("");
                
        	}
        	else if(bonusValue)
        	{
	        		argTest.goSpace();
	        		total = total + bonusCredit;
	        		System.out.println("------------------------------------------------------");
	        		System.out.println("\nTotal Credits Won :" + total+ " credits");
	        	    break;
        	}
        	else {
	        		System.out.println("Player passes Go and is not awarded 200 credits.");
	        		total = total;
	        		System.out.println("------------------------------------------------------");
	        		System.out.println("\nTotal Credits Won :" + total+ " credits");
	        	    break;
        	}
        }
	}

	/**
	 * This method checks for the command line argument.If "-dice" is passed as 
	 * command line argument then it prompts the user for input of two dice values.
	 * If the command line argument is null then it randomly generates the two die values.
	 * @param takes diceArgs as input
	 * @return total dice value
	 */
	public int Check_Argument(String[] diceArgs)
	{		
		int die1= 0;
		int die2 =0;
		if (diceArgs.length == 0) {
			
			Dice dice1 = new Dice();
			Dice dice2  = new Dice();
			die1 = dice1.rolldice();
			die2 = dice2.rolldice();		
			totaldice = die1+die2;
			System.out.println("Player rolled " + die1 + " and " + die2 + " = " + totaldice);			
		}
		
		else
		{
			if (diceArgs.length == 1) 
			{
				Scanner in  = new Scanner(System.in);
				System.out.println("Please enter your dice roll :");
				die1 = in.nextInt();
				die2  = in.nextInt();
				totaldice = die1 + die2;
				System.out.println("Player rolled " + die1 + " and " + die2 + " = " + totaldice);
			}
		}
		
		return totaldice;
	}	
	
	/**
	 * The below method retrieves the current location of the player after moving total number of moves.
	 * This method takes totaldice as input and returns  string as current location and prints "Player 
	 * landed on location name".
	 * @param totaldie
	 * @return the currentLocation of the player in string type.
	 */
	public String getLocation(int totaldie)
	{
		Squares space = new Squares();
		CurrentLocation =space.getLocation(totaldie);
		System.out.println("Player landed on " + CurrentLocation);
		return CurrentLocation;
	}
	
	
	/**
	 * The below method pulls the credit value of the space player landed on.
	 * The method takes string type current location as input and returns integer credit value as output.
	 * This method is for Utilities as well as for the spaces.
	 * @param currentlocation
	 * @param totaldie
	 * @return int as credit value of the space
	 */
	public int GetCreditValue(String currentlocation,int totaldie)
	{
		PropertySpaces property = new PropertySpaces();
		Utilities utilitiesobj = new  Utilities();
		if(currentlocation == "Electric Company" || currentlocation == "Water Works")
		{
		Creditvalue = utilitiesobj.retrievemap(currentlocation,totaldie);
		}
		else 
		{
			Creditvalue = property.retrievemap(currentlocation);
			System.out.println(currentlocation + " awards " + Creditvalue + " credits");
		}
		return Creditvalue;
	}
	
	
	/**
	 * This method retrieves the credit value when players lands on the railroad.
	 * Here it keeps track of the number of times the player landed on any of the railroad in the board.
	 * Based on the number of counts the credit value gets displayed.
	 * @param currentLocation
	 * @return credit value
	 */
	public int GetRailRoadCreditValue(String currentLocation)
	{		
		if(currentLocation =="Reading Railroad" || currentLocation =="Pennsylvania Railroad" || currentLocation =="B & O Railroad" || currentLocation =="Short Line Railroad")
		{
			RailRoads rr = new RailRoads();
			RailRoadCreditvalue = rr.RailRoadCreditValue(currentLocation);
		}
		return RailRoadCreditvalue;
	}
	
	/**
	 * This method comes into existence when player lands on Chance.Here chance has few cards which player picks
	 * them randomply.Based on the card picked the credit value gets set.
	 * @param currentLocation
	 * @return credit value
	 */
	public int RetrieveChanceCardsCreditValue(String currentLocation)
	{
		int chancecreditvalue;
		Chance chanceobj = new Chance();
		chancecreditvalue = chanceobj.pullchancecards();
		return chancecreditvalue;
	}
	
	/**
	 * This method comes into existence when player lands on CommunityChest.Here CommunityChest has few cards which player picks
	 * them randomply.Based on the card picked the credit value gets set.
	 * @param currentLocation
	 * @return credit value
	 */
	public int RetrieveCommunityCardsCreditValue(String currentLocation)
	{
		int communitycreditvalue;
		CommunityChest communityobj = new CommunityChest();
		communitycreditvalue = communityobj.pullcommunitycards();
		return communitycreditvalue;
	}

	
	/**
	 * This method checks if player landed in Jail.If Yes then players position is moved to Just visiting
	 * jail and boolean flag of bonus credit sets to false.
	 * Player is terminated from getting 200 bonus credit after passing Go space.
	 * @param currentLocation
	 * @return boolean
	 */
	public boolean goToJail(String currentLocation)
	{
		bonusValue = false;
		System.out.println("Go directly to Jail.Do not pass Go,do not collect 200 credits");		
		return bonusValue;
	}
	
	
	/**
	 * This method just sets the string as soon as player passes Go space.
	 */
	public void goSpace()
	{
		System.out.println("Player passes Go and is awarded 200 credits");
	}
}
