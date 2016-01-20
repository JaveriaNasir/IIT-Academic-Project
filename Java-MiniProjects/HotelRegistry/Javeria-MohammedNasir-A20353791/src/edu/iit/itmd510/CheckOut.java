package edu.iit.itmd510;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CheckOut extends JFrame implements ActionListener {
	private HotelRegistration hotelObj;
	private HashMap<Integer, CustomerDetails> myData;
	private JComboBox comboBox = new JComboBox();
	private JButton btnNewButton;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckOut(HotelRegistration hotelObj) {
		this.hotelObj = hotelObj;		
		myData = hotelObj.getData();
		filldd();
		setTitle("Check-Out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setPreferredSize(new Dimension(390, 160));
		pack();
		
		JLabel lblNewLabel = new JLabel("Room to Check Out :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 16, 186, 32);
		contentPane.add(lblNewLabel);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		comboBox.setBounds(216, 20, 121, 26);
		contentPane.add(comboBox);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(79, 64, 93, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(186, 64, 93, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
	}
	
	public void filldd()
	{
		if(comboBox.getItemCount() > 0)
		{
			comboBox.removeAllItems();
		}
		for (Map.Entry<Integer, CustomerDetails> mp: hotelObj.getData().entrySet()) {
			CustomerDetails cd = mp.getValue();
			if(cd.getIsV() == false)
			{
				comboBox.addItem(mp.getKey());
			}
		}
	}
	
	public void removedetails(Integer roomno)
	{
		for (Map.Entry<Integer, CustomerDetails> mp: myData.entrySet()) {
			CustomerDetails cd = mp.getValue();
			if(cd.getroom() == roomno)
			{
				cd.setIsv(true);
				if(cd.getroomType().equals("King"))
				{
					hotelObj.king++;
				}
				if(cd.getroomType().equals("One Queen"))
				{
					hotelObj.queen++;
				}
				if(cd.getroomType().equals("Two Double Beds"))
				{
					hotelObj.twob++;
				}
				
				if(cd.getroomType().equals("Two Double Beds Plus Cot"))
				{
					hotelObj.twobc++;
				}
				hotelObj.settxtnum();
				break;
			}
		}
		hotelObj.setMapdata(myData);
		if(roomno == 100)
		{
			hotelObj.textField.setText("Vacant");
		}
		if(roomno == 101)
		{
			hotelObj.textField.setText("Vacant");
		}
		if(roomno == 102)
		{
			hotelObj.textField_2.setText("Vacant");
		}
		if(roomno == 103)
		{
			hotelObj.textField_3.setText("Vacant");
		}
		if(roomno == 104)
		{
			hotelObj.textField_4.setText("Vacant");
		}
		if(roomno == 105)
		{
			hotelObj.textField_5.setText("Vacant");
		}
		if(roomno == 106)
		{
			hotelObj.textField_6.setText("Vacant");
		}
		if(roomno == 107)
		{
			hotelObj.textField_7.setText("Vacant");
		}
		if(roomno == 108)
		{
			hotelObj.textField_8.setText("Vacant");
		}
		if(roomno == 109)
		{
			hotelObj.textField_9.setText("Vacant");
		}
		if(roomno == 110)
		{
			hotelObj.textField_10.setText("Vacant");
		}
		if(roomno == 111)
		{
			hotelObj.textField_11.setText("Vacant");
		}
		if(roomno == 112)
		{
			hotelObj.textField_12.setText("Vacant");
		}
		if(roomno == 113)
		{
			hotelObj.textField_13.setText("Vacant");
		}
		if(roomno == 114)
		{
			hotelObj.textField_14.setText("Vacant");
		}
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton)
		{
			removedetails((Integer)comboBox.getSelectedItem());
		}
	}

}
