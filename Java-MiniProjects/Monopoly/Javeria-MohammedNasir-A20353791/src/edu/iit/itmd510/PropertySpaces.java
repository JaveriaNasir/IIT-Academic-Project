package edu.iit.itmd510;

import java.util.HashMap;
import java.util.Map;

public class PropertySpaces {

	protected HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	/**
	 * The constructor is used to add values to the hashmap.This hashmap adds key and value pair.
	 */
	public PropertySpaces() {
		map.put("Go",0);
		map.put("Mediterranean Avenue",60);
		map.put("Community Chest", 0);
		map.put("Baltic Avenue",60);
		map.put("Income Tax",200);
		map.put("Reading Railroad", 0);		
		map.put("Oriental Avenue",100);
		map.put("Chance", 0);
		map.put("Vermont Avenue",100);
		map.put("Connecticut Avenue",120);
		map.put("Jail - Just Visiting", 0);
		map.put("St. Charles Place",140);
		map.put("Electric Company", 5);
		map.put("States Avenue",140);
		map.put("Virginia Avenue",160);
		map.put("Pennsylvania Railroad", 0);
		map.put("St. James Place",180);
		map.put("Community Chest", 0);
		map.put("Tennessee Avenue",180);
		map.put("New York Avenue",200);
		map.put("Free Parking", 0);
		map.put("Kentucky Avenue",220);
		map.put("Chance", 0);
		map.put("Indiana Avenue",220);
		map.put("Illinois Avenue",240);
		map.put("B & O Railroad", 0);
		map.put("Atlantic Avenue",260);
		map.put("Ventnor Avenue",260);
		map.put("Water Works", 10);
		map.put("Marvin Gardens",280);
		map.put("Go To Jail", 0);
		map.put("Pacific Avenue",300);
		map.put("North Carolina Avenue",300);
		map.put("Community Chest", 0);
		map.put("Pennsylvania Avenue",320);
		map.put("Short Line Railroad", 0);
		map.put("Chance", 0);
		map.put("Park Place",350);
		map.put("Luxury Tax", 100);
		map.put("Boardwalk",400);
	}		
	
	
	/**This method is used to retrieve the credit value of the particular space.
	 * @param mykey
	 * @return creditvalue
	 */
	public int retrievemap(String mykey)
	{		
		 return map.get(mykey);		
	}
	

	
	
	

}
