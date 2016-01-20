package edu.iit.itmd510;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class MonopolyTest {

	@Test
	public void givenDiceAsCommandLineArg() {
		Monopoly args = new Monopoly();
		String strName = "";
		String[] strArray = null;
		int totaldice = 0;
        Given:
        	 strName = "-dice";
			 strArray = new String[] {strName};

        When:
        	strName = "-dice";
        	totaldice = args.Check_Argument(strArray);

        Then:
        	assertEquals(11,totaldice);
    }
	
	@Test
	public void noCommandLineArgument() {
		Monopoly args = new Monopoly();
		String strName = "";
		String[] strArray = null;
		int totaldice = 0;
        Given:
        	 strName = "";
			 strArray = new String[]{};

        When:
        	strName = "";
        	totaldice = args.Check_Argument(strArray);

        Then:
        	assertNotNull(totaldice);
    }
	
	@Test
	public void landsOnStCharlesPlace() {
		Monopoly args = new Monopoly();
		int totaldice = 0;
		String CurrentLocation = "";
		int totalcreditvalue = 0;
        Given:
        	totaldice = 11;

        When:
        	CurrentLocation = args.getLocation(totaldice);
	

        Then:
        	assertEquals("St. Charles Place",CurrentLocation);
    }
	
	@Test
	public void landsOnStCharlesPlacePays140Credits() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int creditvalue = 0;
		int totaldie = 0;
        Given:
        	currentlocation = "St. Charles Place";
			totaldie = 11;

        When:
        	creditvalue= args.GetCreditValue(currentlocation,totaldie);
	

        Then:
        	assertEquals(140,creditvalue);
    }

	@Test
	public void landsOnReadingRailRoadPay200Credits() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int value = 0;
        Given:
        	currentlocation = "Pennsylvania Railroad";

        When:
        	value= args.GetRailRoadCreditValue(currentlocation);
	

        Then:
        	assertEquals(200,value);
    }
	
	@Test
	public void landsOnIncomeTaxPay200Credit() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int creditvalue = 0;
		int totaldie = 0;
        Given:
        currentlocation = "Income Tax";
		totaldie = 4;

        When:
        	creditvalue= args.GetCreditValue(currentlocation,totaldie);
	

        Then:
        	assertEquals(200,creditvalue);
    }
	
	@Test
	public void landsOnLuxuryTaxPay100Credit() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int creditvalue = 0;
		int totaldie = 0;
        Given:
        currentlocation = "Luxury Tax";
		totaldie = 4;

        When:
        	creditvalue= args.GetCreditValue(currentlocation,totaldie);
	

        Then:
        	assertEquals(100,creditvalue);
    }
	
	@Test
	public void landsOnElectricCompanyPay30Credit() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int creditvalue = 0;
		int totaldie = 0;
        Given:
        currentlocation = "Electric Company";
		totaldie = 6;

        When:
        	creditvalue= args.GetCreditValue(currentlocation,totaldie);
	

        Then:
        	assertEquals(30,creditvalue);
    }
	
	@Test
	public void landsOnWaterWorksPay60Credit() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int creditvalue = 0;
		int totaldie = 0;
        Given:
        currentlocation = "Water Works";
		totaldie = 6;

        When:
        	creditvalue= args.GetCreditValue(currentlocation,totaldie);
	

        Then:
        	assertEquals(60,creditvalue);
    }
	
	@Test
	public void retrieveRandomChanceCards() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int value = 0;
        Given:
        	currentlocation = "Chance";

        When:
        	value= args.RetrieveChanceCardsCreditValue(currentlocation);

        Then:
        	assertNotNull(value);
    }
	
	@Test
	public void retrieveRandomCommunityCards() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		int value = 0;
        Given:
        	currentlocation = "Community Chest";

        When:
        	value= args.RetrieveCommunityCardsCreditValue(currentlocation);

        Then:
        	assertNotNull(value);
    }
	
	@Test
	public void goToJail() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		boolean bonusValue;
        Given:
        	currentlocation = "Go To Jail";
			bonusValue = true;

        When:
        	bonusValue= args.goToJail(currentlocation);

        Then:
        	assertNotNull(bonusValue);
    }
	
	@Test
	public void goSpace() {
		Monopoly args = new Monopoly();
		String currentlocation = "";
		boolean bonusValue;
        Given:
        	currentlocation = "Go";
			bonusValue = true;

        When:
        	args.goSpace();

        Then:
        	assertNotNull(bonusValue);
    }
	
	@Test
	public void completeFunctionality() {
		Monopoly args = new Monopoly();
		String strName = "";
		String[] strArray = null;
		int totaldice = 0;
		String totalValue="";
        Given:
        	 strName = "";
			 strArray = new String[]{};

        When:
        	strName = "";
        	args.main(strArray);

        Then:
        	assertNotNull(totalValue);
    }
}
