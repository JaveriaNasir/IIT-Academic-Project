package edu.iit.itmd510;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.Dialog.ModalExclusionType;

public class HotelRegistration extends JFrame {

	int king=4,queen=3,twob=6,twobc=2;
	CheckIn checkInFrame;
	CheckOut checkOutFrame;
	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	private JMenuItem mntmCheckin;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;
	public JTextField textField_9;
	public JTextField textField_10;
	public JTextField textField_11;
	public JTextField textField_12;
	public JTextField textField_13;
	public JTextField textField_14;
	public JTextField textField_15;
	public JTextField textField_16;
	public JTextField textField_17;
	public JTextField textField_18;
	HashMap<Integer,CustomerDetails> myData;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelRegistration frame = new HotelRegistration();
					frame.setVisible(true);			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Setting the text values for the number of rooms based on room type
	 */
	public void settxtnum()
	{
		textField_15.setText("" + king);
		textField_16.setText("" + queen);
		textField_17.setText("" + twob);
		textField_18.setText("" + twobc);
	}
	
	public HashMap<Integer, CustomerDetails> getData()
	{
		return myData;
	}
	
	public void setMapdata(HashMap<Integer, CustomerDetails> data)
	{
		myData = data;
		checkOutFrame.filldd();
	}
	/**
	 * 	HashMap for roomtype values
	 */
	public void setMap()
	{
		myData.put(100, new CustomerDetails("King"));
		myData.put(101, new CustomerDetails("Two Double Beds"));
		myData.put(102, new CustomerDetails("King"));
		myData.put(103, new CustomerDetails("Two Double Beds Plus Cot"));
		myData.put(104, new CustomerDetails("One Queen"));
		myData.put(105, new CustomerDetails("King"));
		myData.put(106, new CustomerDetails("One Queen"));
		myData.put(107, new CustomerDetails("Two Double Beds"));
		myData.put(108, new CustomerDetails("One Queen"));
		myData.put(109, new CustomerDetails("Two Double Beds Plus Cot"));
		myData.put(110, new CustomerDetails("Two Double Beds"));
		myData.put(111, new CustomerDetails("Two Double Beds"));
		myData.put(112, new CustomerDetails("Two Double Beds"));
		myData.put(113, new CustomerDetails("Two Double Beds"));
		myData.put(114, new CustomerDetails("King"));
	}
	
	/**
	 * Create the frame.
	 */
	public HotelRegistration() { 
		//HashMap for roomtype values
		myData = new HashMap<Integer,CustomerDetails>();
		setMap();
				
		checkInFrame = new CheckIn(this);
		checkOutFrame = new CheckOut(this);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setBackground(SystemColor.activeCaption);
		setTitle("Hotel Registry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setPreferredSize(new Dimension(1000, 650));
		pack();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.background"));
		menuBar.setBounds(0, 0, 978, 31);
		contentPane.add(menuBar);
		
		JMenu mnRegistry = new JMenu("Registry");
		mnRegistry.setFont(new Font("Tahoma", Font.BOLD, 19));
		menuBar.add(mnRegistry);
		
		mntmCheckin = new JMenuItem("Check-In");
		mntmCheckin.setFont(new Font("Tahoma", Font.BOLD, 19));
		mnRegistry.add(mntmCheckin);
		
		mntmCheckin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				checkInFrame.setVisible(true);
			}
		});
		
		JMenuItem mntmCheckout = new JMenuItem("Check-Out");
		mntmCheckout.setFont(new Font("Tahoma", Font.BOLD, 19));
		mnRegistry.add(mntmCheckout);
		checkOutFrame = new CheckOut(this);
		mntmCheckout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				checkOutFrame.setVisible(true);
			}
		});
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 19));
		mnRegistry.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Tahoma", Font.BOLD, 19));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Tahoma", Font.BOLD, 19));
		mnHelp.add(mntmAbout);
		About aboutFrame = new About();
		mntmAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				aboutFrame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Room");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 31, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblGuest = new JLabel("Guest");
		lblGuest.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGuest.setBounds(167, 31, 69, 20);
		contentPane.add(lblGuest);
		
		JLabel label = new JLabel("100 :");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(10, 60, 69, 20);
		contentPane.add(label);
		
		textField = new JTextField("Vacant");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(108, 58, 250, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel label_1 = new JLabel("101 :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(10, 96, 69, 20);
		contentPane.add(label_1);
		
		textField_1 = new JTextField("Vacant");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(108, 94, 250, 26);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("102 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 132, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("103 :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(10, 168, 69, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("104 :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(10, 204, 69, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("105 :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(10, 240, 69, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("106 :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_5.setBounds(10, 276, 69, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("107 :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_6.setBounds(10, 312, 69, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("108 :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_7.setBounds(10, 348, 69, 20);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("109 :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_8.setBounds(10, 384, 69, 20);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("110 :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_9.setBounds(10, 420, 69, 20);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("111 :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_10.setBounds(10, 456, 69, 20);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("112 :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_11.setBounds(10, 492, 69, 20);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("113 :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_12.setBounds(10, 528, 69, 20);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("114 :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_13.setBounds(10, 564, 69, 20);
		contentPane.add(label_13);
		
		textField_2 = new JTextField("Vacant");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_2.setColumns(10);
		textField_2.setBounds(108, 130, 250, 26);
		contentPane.add(textField_2);
		textField_2.setEditable(false);

		
		textField_3 = new JTextField("Vacant");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_3.setColumns(10);
		textField_3.setBounds(108, 166, 250, 26);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField("Vacant");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_4.setColumns(10);
		textField_4.setBounds(108, 202, 250, 26);
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField("Vacant");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_5.setColumns(10);
		textField_5.setBounds(108, 240, 250, 26);
		textField_5.setEditable(false);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField("Vacant");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_6.setColumns(10);
		textField_6.setBounds(108, 274, 250, 26);
		textField_6.setEditable(false);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField("Vacant");
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_7.setColumns(10);
		textField_7.setBounds(108, 310, 250, 26);
		textField_7.setEditable(false);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField("Vacant");
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_8.setColumns(10);
		textField_8.setBounds(108, 346, 250, 26);
		textField_8.setEditable(false);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField("Vacant");
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_9.setColumns(10);
		textField_9.setBounds(108, 382, 250, 26);
		textField_9.setEditable(false);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField("Vacant");
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_10.setColumns(10);
		textField_10.setBounds(108, 418, 250, 26);
		textField_10.setEditable(false);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField("Vacant");
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_11.setColumns(10);
		textField_11.setBounds(108, 454, 250, 26);
		textField_11.setEditable(false);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField("Vacant");
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_12.setColumns(10);
		textField_12.setBounds(108, 490, 250, 26);
		textField_12.setEditable(false);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField("Vacant");
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_13.setColumns(10);
		textField_13.setBounds(108, 526, 250, 26);
		textField_13.setEditable(false);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField("Vacant");
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_14.setColumns(10);
		textField_14.setBounds(108, 562, 250, 26);
		textField_14.setEditable(false);
		contentPane.add(textField_14);
		
		JPanel panel = new JPanel();
		panel.setBounds(405, 47, 573, 537);
		panel.setBorder(BorderFactory.createTitledBorder("Vacancies"));
		panel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOneKing = new JLabel("One King");
		lblOneKing.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOneKing.setBounds(15, 62, 86, 29);
		panel.add(lblOneKing);
		
		JLabel lblNewLabel_2 = new JLabel("One Queen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(15, 195, 121, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblTwoDoubleBeds = new JLabel("Two Double Beds");
		lblTwoDoubleBeds.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTwoDoubleBeds.setBounds(15, 340, 181, 29);
		panel.add(lblTwoDoubleBeds);
		
		JLabel lblTwoDoubleBeds_1 = new JLabel("Two Double Beds w/Cot");
		lblTwoDoubleBeds_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTwoDoubleBeds_1.setBounds(15, 476, 231, 29);
		panel.add(lblTwoDoubleBeds_1);
		
		textField_15 = new JTextField("4");
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_15.setBounds(286, 64, 272, 27);
		panel.add(textField_15);
		textField_15.setColumns(10);
		textField_15.setEditable(false);
		
		textField_16 = new JTextField("3");
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_16.setColumns(10);
		textField_16.setBounds(286, 197, 272, 29);
		panel.add(textField_16);
		textField_16.setEditable(false);
		
		
		textField_17 = new JTextField("6");
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_17.setColumns(10);
		textField_17.setBounds(286, 340, 272, 28);
		panel.add(textField_17);
		textField_17.setEditable(false);
		
		textField_18 = new JTextField("2");
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_18.setColumns(10);
		textField_18.setBounds(286, 475, 272, 29);
		panel.add(textField_18);
		textField_18.setEditable(false);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
