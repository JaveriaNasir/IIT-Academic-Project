package edu.iit.itmd510;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJaveriaMohammedNasir = new JLabel("Javeria Mohammed Nasir");
		lblJaveriaMohammedNasir.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJaveriaMohammedNasir.setBounds(15, 29, 245, 20);
		contentPane.add(lblJaveriaMohammedNasir);
		
		JLabel lblA = new JLabel("A20353791");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblA.setBounds(15, 65, 148, 20);
		contentPane.add(lblA);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setBounds(166, 124, 72, 29);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		
	}
}
