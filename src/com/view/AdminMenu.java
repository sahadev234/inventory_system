package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setTitle("Admin Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(203, 203, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cashier");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                AddCashier addcashier = new AddCashier(); // Create instance of Page2
                addcashier.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton.setBounds(538, 174, 235, 61);
		contentPane.add(btnNewButton);
		
		JButton btnSearchBill = new JButton("Transaction");
		btnSearchBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                SearchBill searchbill = new SearchBill(); // Create instance of Page2
                searchbill.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnSearchBill.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchBill.setBounds(538, 277, 235, 61);
		contentPane.add(btnSearchBill);
		
		JButton btnNewButton_1_1 = new JButton("Sales");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(538, 489, 235, 61);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Exit");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                CashierLogin cashierLogin = new CashierLogin(); // Create instance of Page2
                cashierLogin.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1_1.setBounds(538, 603, 235, 61);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Stock");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                UpdateStock updateStock = new UpdateStock(); // Create instance of Page2
                updateStock.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1_1_1.setBounds(538, 385, 235, 61);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CashierMenu.class.getResource("/images/Screenshot (22).png")));
		lblNewLabel.setBounds(0, 0, 177, 142);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quick Bill");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(33, 153, 153, 42);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                LoginForm loginForm = new LoginForm(); // Create instance of Page2
                loginForm.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(10, 640, 130, 51);
		contentPane.add(btnNewButton_1);
	}

}
