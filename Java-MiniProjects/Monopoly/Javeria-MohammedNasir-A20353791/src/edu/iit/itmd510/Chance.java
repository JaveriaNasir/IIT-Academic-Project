package edu.iit.itmd510;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Chance extends PropertySpaces{

	public ArrayList<String> chancescards = new ArrayList<String>(5);;
	private Random randomGenerator = new Random();
	int chancecreditvalue;
	
	
	/**In the constructor of Chance class initializing the arraylist and adding values to it.
	 * 
	 */
	public Chance()
	{
		chancescards.add("Go directly to Jail");
		chancescards.add("Bank pays you dividend of 50 credits");
		chancescards.add("Go back 3 spaces");
		chancescards.add("You have won a crossword competition. Collect 10 credits");
		chancescards.add("You have been elected Chairman of the Board. Collect 100 credits");
	}
	
	/**
	 * This method calls PickRandomChanceCards method internally and returns ChanceCreditValue.
	 * @return ChanceCreditValue
	 */
	public int pullchancecards()
	{
		chancecreditvalue = PickRandomChanceCards(chancescards);
		return chancecreditvalue;
	}
	
	/**This method retirves random value from arraylist and checks the hashmap for the corresponding value for creditvalue
	 * @param chancescards
	 * @return ChanceCreditValue
	 */
	public int PickRandomChanceCards(ArrayList<String> chancescards)
	{
		HashMap<String, Integer> mapchancecards = new HashMap<String, Integer>();
		mapchancecards.put("Go directly to Jail", 0);
		mapchancecards.put("Bank pays you dividend of 50 credits", 50);
		mapchancecards.put("Go back 3 spaces", 3);
		mapchancecards.put("You have won a crossword competition. Collect 10 credits", 10);
		mapchancecards.put("You have been elected Chairman of the Board. Collect 100 credits", 100);
		
		int index = randomGenerator.nextInt(chancescards.size());
        String value = chancescards.get(index);
        System.out.println(value);        
        chancecreditvalue = mapchancecards.get(value);		
		return chancecreditvalue;
	}
	
	
	
}
