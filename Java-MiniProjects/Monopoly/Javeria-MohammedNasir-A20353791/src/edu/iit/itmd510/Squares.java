package edu.iit.itmd510;

import java.util.ArrayList;

public class Squares {
	private ArrayList<String> spaces = new ArrayList<String>(40);
	public Squares()
	{
		spaces.add("Go");
		spaces.add("Mediterranean Avenue");
		spaces.add("Community Chest");
		spaces.add("Baltic Avenue");
		spaces.add("Income Tax");
		spaces.add("Reading Railroad");
		spaces.add("Oriental Avenue");
		spaces.add("Chance");
		spaces.add("Vermont Avenue");
		spaces.add("Connecticut Avenue");
		spaces.add("Jail - Just Visiting");
		spaces.add("St. Charles Place");
		spaces.add("Electric Company");
		spaces.add("States Avenue");
		spaces.add("Virginia Avenue");
		spaces.add("Pennsylvania Railroad");
		spaces.add("St. James Place");
		spaces.add("Community Chest");
		spaces.add("Tennessee Avenue");
		spaces.add("New York Avenue");
		spaces.add("Free Parking");
		spaces.add("Kentucky Avenue");
		spaces.add("Chance");
		spaces.add("Indiana Avenue");
		spaces.add("Illinois Avenue");
		spaces.add("B & O Railroad");
		spaces.add("Atlantic Avenue");
		spaces.add("Ventnor Avenue");
		spaces.add("Water Works");
		spaces.add("Marvin Gardens");
		spaces.add("Go To Jail");
		spaces.add("Pacific Avenue");
		spaces.add("North Carolina Avenue");
		spaces.add("Community Chest");
		spaces.add("Pennsylvania Avenue");
		spaces.add("Short Line Railroad");
		spaces.add("Chance");
		spaces.add("Park Place");
		spaces.add("Luxury Tax");
		spaces.add("Boardwalk");		
	}
	

	public String getLocation(int totaldice) {
		
		return spaces.get(totaldice);
	}
}
