

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TwoPlayerGameOfLife {

	public static int head_row = 0;
	public static int head_col = 0;
	public static int player_one_count = 0;
	public static int player_two_count = 0;
	public static char[][] global_arr = null;

	/**
	 * Returns an chararray initial size to store initial state
	 * 
	 * @param char
	 *            Array which has info for the 1st row only
	 * @return returns the initialize char array
	 */
	private static char[][] get_array_file(String[] header) {

		int row = 0;
		int col = 0;
		if (header.length == 2) {
			row = Integer.parseInt(header[0]);
			col = Integer.parseInt(header[1]);

			head_row = row;
			head_col = col;
			System.out.println("No of rows >> " + head_row);
			System.out.println("No of Columns >> " + head_col);
		}
		char[][] gen_array = new char[row][col];
		System.out.printf("\nTotal Elements : %d", row * col);
		global_arr = gen_array;
		return gen_array;
	}

	/**
	 *  Any live cell with fewer than two live neighbors dies (under
	 * population)  Any live cell with two or three live neighbors lives.  Any
	 * live cell with more than three neighbors dies (over population)  Any
	 * dead cell with exactly three neighbors becomes a live cell.
	 */

	public static void print_array(char[][] a) {
		System.out.println("\nGeneration #0 ....");
		System.out.println("Player 1 Cells : " + player_one_count);
		System.out.println("Player 2 Cells : " + player_two_count);

		for (int i = 0; i < head_col; i++) {
			for (int j = 0; j < head_col; j++) {
				System.out.printf("%5c ", a[i][j]);
			}
			System.out.println();
		}

	}

	private static void increment_player_counter(char element) {
		if (element == '1')
			player_one_count++;
		if (element == '2')
			player_two_count++;
	}

	private static void position(char[][] a, char player) {
		char[][] temp_arr = new char[head_row][head_col];
		for (int i = 0; i < head_row; i++) {
			for (int j = 0; j < head_col; j++) {
				if (a[i][j] == player) {
					System.out.printf("\nCurrent Position %d x %d\n", i, j);

					if (neighbours(i, j) > 3 || neighbours(i, j) < 2) {
						a[i][j] = '.';
					} else if (neighbours(i, j) == 3) {
						a[i][j] = player;
					}
				}
			}
			// System.out.println();
		}
		print_array(a);
		// position(a, '1');
		// print_array(a);
	}

	public static int neighbours(int row, int col) {
		int acc = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				try {
					if (global_arr[i][j] == '1' && (i != row || j != col)) {
						acc++;
					}
				} catch (ArrayIndexOutOfBoundsException f) {
					continue;
				}
			}
		}
		return acc;
	}

	public static boolean isAlive(char element) {
		if (element == '1' || element == '2')
			return true;
		else
			return false;
	}

	public static boolean isDead(char element) {
		if (element == '.')
			return true;
		else
			return false;
	}

	/**
	 * Returns
	 * 
	 * @param needs
	 *            generation file location
	 * @return 
	 * @return returns the initial size of char array
	 */
	public static String[] readFile(File fin) throws IOException {
		String[] list = new String[10];
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(fin));
			String text = null;
			int row = 0;
			char[][] gen_array = null;
			String[] dish = null;

			while ((text = reader.readLine()) != null) {
				if (row == 0) {
					// This is 1st row which has row & column info
					gen_array = get_array_file(text.split(" "));
				} else {
					char[] charArray = text.toCharArray();

					for (int i = 0; i < head_col; i++) {
						// System.out.println(">> "+charArray[i]);
						if (charArray[i] == '1' || charArray[i] == '2' || charArray[i] == '.') {
							gen_array[row - 1][i] = charArray[i];
							increment_player_counter(charArray[i]);
						} else {
							System.err.println("Invalid element in generation file");
							System.exit(1);
						}
					}
					System.out.println(text.toCharArray());
					list[row - 1] = text;
				}
				row++;
			}
			//list = dish;
			print_array(gen_array);
			
			//int i = 3;
			
			/*
			 * while(i>0){ position(gen_array,'1'); position(gen_array,'2');
			 * i--; }
			 */

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Invalid generation file");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return list;
	}
	
	public static char winner(String[] dish){
		int count_player_1 = 0; 
		int count_player_2 = 0; 
		for (int row = 0; row < dish.length; row++) {
			for (int i = 0; i < dish[row].length(); i++){
				if(dish[row].charAt(i)=='1')
					count_player_1++;
				else if(dish[row].charAt(i)=='2')
					count_player_2++;
				//System.out.println(dish[row].charAt(i));
			}
		}
		System.out.printf("Player 1 : %d",count_player_1);
		System.out.printf("Player 2 : %d",count_player_2);
		if (count_player_1 > count_player_2)
			return '1';
		if (count_player_1 < count_player_2)
			return '2';
		else
			return ' ';
		
	}

	public static String[] life(String[] dish) {
		String[] newGen = new String[dish.length];
		for (int row = 0; row < dish.length; row++) {// each row
			newGen[row] = "";
			for (int i = 0; i < dish[row].length(); i++) {// each char in the
															// row
				String above = "";// neighbors above
				String same = "";// neighbors in the same row
				String below = "";// neighbors below
				if (i == 0) {// all the way on the left
					// no one above if on the top row
					// otherwise grab the neighbors from above
					above = (row == 0) ? null : dish[row - 1].substring(i, i + 2);
					same = dish[row].substring(i + 1, i + 2);
					// no one below if on the bottom row
					// otherwise grab the neighbors from below
					below = (row == dish.length - 1) ? null : dish[row + 1].substring(i, i + 2);
				} else if (i == dish[row].length() - 1) {// right
					// no one above if on the top row
					// otherwise grab the neighbors from above
					above = (row == 0) ? null : dish[row - 1].substring(i - 1, i + 1);
					same = dish[row].substring(i - 1, i);
					// no one below if on the bottom row
					// otherwise grab the neighbors from below
					below = (row == dish.length - 1) ? null : dish[row + 1].substring(i - 1, i + 1);
				} else {// anywhere else
						// no one above if on the top row
						// otherwise grab the neighbors from above
					above = (row == 0) ? null : dish[row - 1].substring(i - 1, i + 2);
					same = dish[row].substring(i - 1, i) + dish[row].substring(i + 1, i + 2);
					// no one below if on the bottom row
					// otherwise grab the neighbors from below
					below = (row == dish.length - 1) ? null : dish[row + 1].substring(i - 1, i + 2);
				}
				int neighbors = getNeighbors(above, same, below);
				if (neighbors < 2 || neighbors > 3) {
					newGen[row] += ".";// <2 or >3 neighbors -> die
				} else if (neighbors == 3) {
					newGen[row] += "1";// 3 neighbors -> spawn/live
				} else if (neighbors == 3) {
					newGen[row] += "2";// 3 neighbors -> spawn/live
				} else {
					newGen[row] += dish[row].charAt(i);// 2 neighbors -> stay
				}
			}
		}
		return newGen;
	}

	public static int getNeighbors(String above, String same, String below) {
		int ans = 0;
		if (above != null) {// no one above
			for (char x : above.toCharArray()) {// each neighbor from above
				if (x == '1')
					ans++;// count it if someone is here
				if (x == '2')
					ans++;
			}
		}
		for (char x : same.toCharArray()) {// two on either side
			if (x == '1')
				ans++;
			if (x == '2')
				ans++;// count it if someone is here
		}
		if (below != null) {// no one below
			for (char x : below.toCharArray()) {// each neighbor below
				if (x == '1')
					ans++;
				if (x == '2')
					ans++;// count it if someone is here
			}
		}
		return ans;
	}

	public static void print(String[] dish) {
		for (String s : dish) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("There were no commandline arguments passed! \n Please pass generation file");
			System.exit(1);

		} else {
			if (args.length == 1) {
				System.out.println("Generation file name is :" + args[0]);
				if (args[0].endsWith(".txt"))
					try {
						String[] dish = readFile(new File(args[0]));
						
						int gens = 10;
						for (int i = 0; i < gens; i++) {
							System.out.println("Generation " + i + ":");
							print(dish);
							dish = life(dish);
							TimeUnit.SECONDS.sleep(3);
						}
						
					} catch (IOException e) {
						System.err.println("Error while opening file");
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

	}

}
