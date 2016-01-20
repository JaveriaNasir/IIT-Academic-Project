package edu.iit.itmd510;

public class Utilities extends PropertySpaces {

	
	/**
	 * This class is a child class of parent class(PropertySpaces)
	 * The method uses the polymorphism concept.
	 * This method checks for Electric company or water works and based on that it decides the credit value.
	 * @param mykey
	 * @param totaldicenumber
	 * @return credit value
	 */
	public int retrievemap(String mykey,Integer totaldicenumber)
	{
		int utilitiesCreditValue;
		int creditValue = map.get(mykey);
		String location = mykey;
		utilitiesCreditValue = map.get(mykey)*totaldicenumber;	
		System.out.println(location + " awards " +"(" + totaldicenumber +")" + " * " + creditValue + " = " + utilitiesCreditValue + " credits.");
		return utilitiesCreditValue;
	}
}
