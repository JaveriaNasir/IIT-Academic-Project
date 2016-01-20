
import TwoPlayerGameOfLife;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class TwoPlayerGameOfLifeTest {

    @Test
    public void testReadInitialFile() {
    	//URL path = ClassLoader.getSystemResource("generation0.txt");
    	File fp = new File("C:\\Users\\javeria\\workspace\\Game_Of_Life\\src\\iit\\itm510\\generation0.txt");
    	try {
    		TwoPlayerGameOfLife.readFile(fp);
		} catch (IOException e) {
			e.printStackTrace();
			assertFalse(false);
		}
        //assertTrue(collection.isEmpty());
    }
    
    @Test
    public void testisAlive() {
    	assertEquals(TwoPlayerGameOfLife.isAlive('1'), true);
    }
    
    @Test
    public void testisDead() {
    	assertEquals(TwoPlayerGameOfLife.isDead('.'), true);
    }
    
    @Test
    public void liveCellWithFewerThanTwoNeighborsShouldDie() {
    	System.out.println("liveCellWithFewerThanTwoNeighborsShouldDie():Start");
    	String[] state = new String[1];
    	state[0] = "........11...";
    	String[] newState = TwoPlayerGameOfLife.life(state);
    	TwoPlayerGameOfLife.print(newState);
    	assertEquals(TwoPlayerGameOfLife.isAlive('1'), true);
    	System.out.println("liveCellWithFewerThanTwoNeighborsShouldDie():End\n\n");
    }
    
    
    @Test
    public void decideWinner() {
    	System.out.println("decideWinner():Start");
    	String[] state = new String[2];
    	state[0] = "........11...";
    	state[1] = "........222..";
    	System.out.printf("\nWinner is %s :",TwoPlayerGameOfLife.winner(state));
    	System.out.println("decideWinner():End\n\n");
    }
   

}
