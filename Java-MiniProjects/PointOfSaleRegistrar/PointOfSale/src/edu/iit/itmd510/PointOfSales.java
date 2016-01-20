package edu.iit.itmd510;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PointOfSales extends JFrame {

	private JPanel contentPane;
	private JTextField totalItems;
	private JTextField totalCost;
	private JTextField SKU;
	private HashMap<String,Stocks> myMap = new HashMap<String,Stocks>();
	private double ttlcst;
	private int ttlitems=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointOfSales objpos = new PointOfSales();
					objpos.readCostsFile();
					objpos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PointOfSales() {
		setTitle("Point of Sale Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 979, 31);
		contentPane.add(menuBar);
		
		JMenu mnRegister = new JMenu("Register");
		menuBar.add(mnRegister);
		mnRegister.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnRegister.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		mnHelp.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		mntmAbout.setFont(new Font("Tahoma", Font.BOLD, 19));
		About aboutFrame = new About();
		mntmAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				aboutFrame.setVisible(true);
			}
		});
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 47, 954, 288);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Total Items : ");
		lblNewLabel.setBounds(247, 375, 130, 31);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		totalItems = new JTextField();
		totalItems.setBounds(377, 379, 61, 26);
		contentPane.add(totalItems);
		totalItems.setColumns(10);
		totalItems.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Total Cost :");
		lblNewLabel_1.setBounds(463, 377, 120, 26);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		totalCost = new JTextField();
		totalCost.setBounds(587, 379, 146, 26);
		contentPane.add(totalCost);
		totalCost.setColumns(10);
		totalCost.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("SKU :");
		lblNewLabel_2.setBounds(296, 425, 61, 20);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		SKU = new JTextField();
		SKU.setBounds(377, 425, 146, 26);
		contentPane.add(SKU);
		SKU.setColumns(10);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddItem.setBounds(549, 422, 115, 29);
		contentPane.add(btnAddItem);
		
		btnAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String skuval = SKU.getText().trim();
				if(myMap.containsKey(skuval.trim()))
				{					
					Stocks stk = myMap.get(skuval);
					double unitvalue = stk.getunitcost()/100;
					DecimalFormat twoDForm = new DecimalFormat("#.00");
					twoDForm.format(unitvalue);
					String txtvalue = textArea.getText();
					txtvalue += "\n" + stk.getsku() + " " + stk.getdescription() + " | ";
					switch (stk.getOffertype())
					{
					case "DISCOUNT":
						double ttl = unitvalue-((stk.getDiscount()*unitvalue)/100);
						txtvalue += "" + stk.getDiscount() + "% off 1@ " + ttl + "= ";
						ttlcst += ttl;
						txtvalue += "" + ttl;
						textArea.setText(txtvalue);
						totalCost.setText(Double.toString(ttlcst));
						ttlitems++;
						totalItems.setText("" + ttlitems);
						break;
					case "BUYXGET1FREE":
						txtvalue += " " + stk.getBuy() + "@ " + unitvalue + " = ";
						double ttla = unitvalue * stk.getBuy();
						ttlcst += ttla;
						ttlitems++;
						txtvalue += "" + ttla;
						txtvalue += "\n" + stk.getsku() + " " + stk.getdescription() + " | ";
						txtvalue += " 1@0.00 = 0.00";
						textArea.setText(txtvalue);
						totalCost.setText(Double.toString(ttlcst));
						ttlitems++;
						totalItems.setText("" + ttlitems);
						break;
					case "BUYXFORY":
						txtvalue += "" + stk.getxbuy() + "for " + stk.getycost() + " @ " + unitvalue + " = ";
						double ttlb = stk.getycost()*unitvalue;
						ttlcst += ttlb;
						txtvalue += "" + ttlb;
						textArea.setText(txtvalue);
						totalCost.setText(Double.toString(ttlcst));
						ttlitems++;
						totalItems.setText("" + ttlitems);
						break;
					}
				}
				else
					System.out.println("Sorry, No such item available.");
			}
		});
		
		JButton btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPay.setBounds(403, 481, 89, 29);
		contentPane.add(btnPay);
		
		JButton btnVoid = new JButton("Void");
		btnVoid.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoid.setBounds(507, 481, 89, 29);
		contentPane.add(btnVoid);			
		
		btnPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String output = textArea.getText().trim();
				output += "\n Total Items: " + ttlitems + "\n Total Cost: " +  " $" + ttlcst;
				output +=  "\n +--------------------------------------------------------+\n";
				writeRegisterTape(output);
				textArea.setText("");
				totalCost.setText("");
				totalItems.setText("");
				SKU.setText("");
				ttlcst = 0;
				ttlitems = 0;
			}
		});
		
		btnVoid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText("");
				totalCost.setText("");
				totalItems.setText("");
				SKU.setText("");
				ttlcst = 0;
				ttlitems = 0;
			}
		});
	}
	
	public void writeRegisterTape(String txt)
	{
		try {

			String content = txt;
			
			File file = new File(".\\src\\edu\\iit\\itmd510\\RegisterTape.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readCostsFile()
	{
		String fileName = ".\\src\\edu\\iit\\itmd510\\CostsFile.txt";
		 String line = null;
		 try {
		 
			 FileReader fileReader = new FileReader(fileName);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 
			 while((line = bufferedReader.readLine()) != null) 
			 {
				 line.trim();
				 String[] desc = line.split("\\|");
	            //System.out.println(desc[0] + " " + desc[1] + " " + desc[2]);
				 Stocks stk = new Stocks(desc[0].trim(),desc[1].trim(),Integer.parseInt(desc[2].trim()));
				 myMap.put(desc[0], stk);
				 
			 }
			 bufferedReader.close();
			 
		 	}
		 catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
		 readDiscountFile();
	}
	
	public void readDiscountFile()
	{
		String fileName = ".\\src\\edu\\iit\\itmd510\\DiscountsFile.txt";
		 String line = null;
		 try {
		 
			 FileReader fileReader = new FileReader(fileName);
			 BufferedReader bufferedReader = new BufferedReader(fileReader);
			 
			 while((line = bufferedReader.readLine()) != null) 
			 {
				 line.trim();
				 String[] desc = line.split("\\|");
				 if(myMap.containsKey(desc[0].trim()))
				 {
					 Stocks stk = myMap.get(desc[0].trim());
					 stk.setOffertype(desc[1].trim());
					 if(desc[1].trim().equals("BUYXGET1FREE"))
					 {
						 stk.setBuy(Integer.parseInt(desc[2].trim()));
					 }
					 if(desc[1].trim().equals("DISCOUNT"))
					 {
						 stk.setDiscount(Integer.parseInt(desc[2].trim()));
					 }
					 if(desc[1].trim().equals("BUYXFORY"))
					 {
						 stk.setXbuy(Integer.parseInt(desc[2].trim()));
						 stk.setycost(Integer.parseInt(desc[3].trim()));
					 }
					 myMap.put(desc[0].trim(),stk);
				 }
				 
			 }
			 bufferedReader.close();
			 
		 	}
		 catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	        }
	}
}
