package edu.iit.itmd510;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class CheckIn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private HashMap<Integer, CustomerDetails> myData;
	private HotelRegistration hotelObj;
	private JComboBox comboBox_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private ButtonGroup btngroup;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//CheckIn frame = new CheckIn();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * resetting all the fields when check in forms re opens.
	 */
	public void resetAllTextFields()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		btngroup.clearSelection();
		comboBox_2.setSelectedItem(null);
	}

	/**
	 * Create the frame.
	 */
	public CheckIn( HotelRegistration hotelObj ) {
		
		this.hotelObj = hotelObj;
		
		myData = hotelObj.getData();
		
		setFont(new Font("Tahoma", Font.PLAIN, 18));
		setTitle("Check-In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 347);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setPreferredSize(new Dimension(1025, 350));
		pack();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFirstName.setBounds(15, 16, 108, 20);
		contentPane.add(lblFirstName);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(177, 14, 300, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLastName.setBounds(492, 16, 108, 20);
		contentPane.add(lblLastName);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(632, 13, 364, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAddress.setBounds(15, 52, 108, 20);
		contentPane.add(lblAddress);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(177, 50, 819, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCity.setBounds(15, 88, 69, 20);
		contentPane.add(lblCity);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setBounds(177, 92, 205, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblState.setBounds(397, 92, 62, 20);
		contentPane.add(lblState);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(457, 92, 164, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel = new JLabel("Zip Code :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(636, 91, 108, 20);
		contentPane.add(lblNewLabel);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setBounds(800, 86, 196, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNumberOfAdults = new JLabel("Number of Adults :");
		lblNumberOfAdults.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNumberOfAdults.setBounds(15, 130, 151, 20);
		contentPane.add(lblNumberOfAdults);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(177, 134, 204, 26);
		contentPane.add(comboBox);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);

		JLabel lblNewLabel_1 = new JLabel("Number of Children :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(615, 130, 183, 20);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(800, 127, 196, 26);
		contentPane.add(comboBox_1);
		comboBox_1.addItem(0);
		comboBox_1.addItem(1);
		comboBox_1.addItem(2);
		comboBox_1.addItem(3);
		comboBox_1.addItem(4);

		JPanel panel = new JPanel();
		panel.setBounds(15, 166, 981, 65);
		panel.setBorder(BorderFactory.createTitledBorder("Room Type"));
		contentPane.add(panel);
		panel.setLayout(null);

		rdbtnNewRadioButton = new JRadioButton("King");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnNewRadioButton.setBounds(11, 24, 155, 29);
		panel.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("One Queen");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnNewRadioButton_1.setBounds(198, 24, 155, 29);
		panel.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("Two Double Beds");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnNewRadioButton_2.setBounds(417, 24, 197, 29);
		panel.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("Two Double Beds Plus Cot");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnNewRadioButton_3.setBounds(682, 24, 272, 29);
		panel.add(rdbtnNewRadioButton_3);

		
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_2.addActionListener(this);
		rdbtnNewRadioButton_3.addActionListener(this);
		
		btngroup=new ButtonGroup();
		btngroup.add(rdbtnNewRadioButton);
		btngroup.add(rdbtnNewRadioButton_1);
		btngroup.add(rdbtnNewRadioButton_2);
		btngroup.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Room :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(15, 247, 69, 20);
		contentPane.add(lblNewLabel_2);

		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_2.setBounds(177, 245, 204, 26);
		contentPane.add(comboBox_2);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean isCorrect = true;
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || 
						textField_3.getText().isEmpty() || textField_4.getText().isEmpty()|| textField_5.getText().isEmpty() ||
						btngroup.isSelected(null)
						)
				{
					 JOptionPane.showMessageDialog(null, "Validation Failure!");
					 textField.requestFocusInWindow();
					 isCorrect = false;
				}
				if(isCorrect)
				{
				int noOfAdults = (Integer)comboBox.getSelectedItem();
				int noOfChildren = (Integer)comboBox_1.getSelectedItem();
				int roomNumber = (Integer)comboBox_2.getSelectedItem();
				

				CustomerDetails custobj = myData.get(comboBox_2.getSelectedItem());
				custobj.setFirstName(textField.getText());
				custobj.setlastName(textField_1.getText());
				custobj.setcustomerAddress(textField_2.getText());
				custobj.setcustomerCity(textField_3.getText());
				custobj.setcustomerState(textField_4.getText());
				custobj.setcustomerZipCode(textField_5.getText());
				custobj.setnumberOfAdults(noOfAdults);
				custobj.setnumberOfChildren(noOfChildren);
				custobj.setroom(roomNumber);
				custobj.setIsv(false);
				
				JRadioButton temp = null;
				if(e.getSource()==btnRegister)  
			     {  
					
			        Enumeration<AbstractButton> allRadioButton=btngroup.getElements();  
			        while(allRadioButton.hasMoreElements())  
			        {  
			           temp=(JRadioButton)allRadioButton.nextElement();  
			           if(temp.isSelected())  
			           {  
			        	   custobj.setroomType(temp.getText());
			        	   break;
			           }  
			        }            
			     }
				
				settxtfield((Integer)comboBox_2.getSelectedItem(),textField.getText());
				
				if(isCorrect)
				{
					if(temp.getText().equals("King"))
					{
						hotelObj.king--;
					}
					if(temp.getText().equals("One Queen"))
					{
						hotelObj.queen--;
					}
					if(temp.getText().equals("Two Double Beds"))
					{
						hotelObj.twob--;
					}
					
					
					if(temp.getText().equals("Two Double Beds Plus Cot"))
					{
						hotelObj.twobc--;
					}
					hotelObj.settxtnum();
					hotelObj.setMapdata(myData);
					resetAllTextFields();
					setVisible(false);
					dispose();
				}
			}
			
			}
		
		});
		
		btnRegister.setBounds(429, 247, 267, 29);
		contentPane.add(btnRegister);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(711, 247, 285, 29);
		contentPane.add(btnCancel);
		
	}
	
	/**
	 * Filling the room combobox based on the selection of roomtype and the availability of the room.
	 * @param hashmap,room type
	 * @param myData
	 */
	public void fillVaccantRoom(String type,HashMap<Integer, CustomerDetails> myData)
	{
		comboBox_2.removeAllItems();
		for (Map.Entry<Integer, CustomerDetails> mp: myData.entrySet()) {
			CustomerDetails cd = mp.getValue();
			if(cd.getIsV() == true && type.equals(cd.getDefaultroomtype()))		
				comboBox_2.addItem(mp.getKey());
		}
	}
	
	/**
	 * This method sets the txtfields of hotel registration with the customer's firstname when he/she check's
	 * into the room.
	 * @param room
	 * @param name
	 */
	public void settxtfield( Integer room, String name)
	{
		HotelRegistration obj = hotelObj;
		if(room == 100 && !name.isEmpty())
		{
			obj.textField.setText(name); 
		}
		if(room == 101 && !name.isEmpty())
		{
			obj.textField_1.setText(name); 
		}
		if(room == 102 && !name.isEmpty())
		{
			obj.textField_2.setText(name); 
		}
		if(room == 103 && !name.isEmpty())
		{
			obj.textField_3.setText(name); 
		}
		if(room == 104 && !name.isEmpty())
		{
			obj.textField_4.setText(name); 
		}
		if(room == 105 && !name.isEmpty())
		{
			obj.textField_5.setText(name); 
		}
		if(room == 106 && !name.isEmpty())
		{
			obj.textField_6.setText(name); 
		}
		if(room == 107 && !name.isEmpty())
		{
			obj.textField_7.setText(name); 
		}
		if(room == 108 && !name.isEmpty())
		{
			obj.textField_8.setText(name); 
		}
		if(room == 109 && !name.isEmpty())
		{
			obj.textField_9.setText(name); 
		}
		if(room == 110 && !name.isEmpty())
		{
			obj.textField_10.setText(name); 
		}
		if(room == 111 && !name.isEmpty())
		{
			obj.textField_11.setText(name); 
		}
		if(room == 112 && !name.isEmpty())
		{
			obj.textField_12.setText(name); 
		}
		if(room == 113 && !name.isEmpty())
		{
			obj.textField_13.setText(name); 
		}
		if(room == 114 && !name.isEmpty())
		{
			obj.textField_14.setText(name); 
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== rdbtnNewRadioButton)
		{
			fillVaccantRoom("King",hotelObj.getData());
		}
		if(e.getSource()== rdbtnNewRadioButton_1)
		{
			fillVaccantRoom("One Queen",hotelObj.getData());
		}
		if(e.getSource()== rdbtnNewRadioButton_2)
		{
			fillVaccantRoom("Two Double Beds",hotelObj.getData());
		}
		if(e.getSource()== rdbtnNewRadioButton_3)
		{
			fillVaccantRoom("Two Double Beds Plus Cot",hotelObj.getData());
		}
		
	}
}
