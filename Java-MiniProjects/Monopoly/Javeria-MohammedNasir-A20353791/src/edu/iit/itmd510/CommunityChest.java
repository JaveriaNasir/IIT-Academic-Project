package edu.iit.itmd510;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CommunityChest extends PropertySpaces{
	
	public ArrayList<String> communityChanceCards = new ArrayList<String>(5);;
	private Random randomGenerator = new Random();
	int communitycreditvalue;
	
	/**In the constructor of CommunityChest class initializing the arraylist and adding values to it.
	 * 
	 */
	public CommunityChest()
	{
		communityChanceCards.add("Bank error in your favor. Collect 200 credits");
		communityChanceCards.add("From sale of stock, you get 50 credits");
		communityChanceCards.add("Go directly to Jail");
		communityChanceCards.add("Holiday Fund matures. Receive 100 credits");
		communityChanceCards.add("Income tax refund. Collect 20 credits");
	}
	
	/**
	 * This method calls PickRandomChanceCards method internally and returns CommunitycreditValue.
	 * @return communitycreditvalue
	 */
	public int pullcommunitycards()
	{
		communitycreditvalue = PickRandomCommunityCards(communityChanceCards);
		return communitycreditvalue;
	}
	
	/**This method retrieves random value from arraylist and checks the hashmap for the corresponding value for creditvalue
	 * @param communityChanceCards
	 * @return communitycreditvalue
	 */
	public int PickRandomCommunityCards(ArrayList<String> communityChanceCards)
	{
		HashMap<String, Integer> mapchancecards = new HashMap<String, Integer>();
		mapchancecards.put("Bank error in your favor. Collect 200 credits", 200);
		mapchancecards.put("From sale of stock, you get 50 credits", 50);
		mapchancecards.put("Go directly to Jail", 0);
		mapchancecards.put("Holiday Fund matures. Receive 100 credits", 100);
		mapchancecards.put("Income tax refund. Collect 20 credits", 20);
		
		int index = randomGenerator.nextInt(communityChanceCards.size());
        String value = communityChanceCards.get(index);
        System.out.println(value);        
        communitycreditvalue = mapchancecards.get(value);
		return communitycreditvalue;
	}
}
