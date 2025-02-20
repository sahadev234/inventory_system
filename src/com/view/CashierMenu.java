package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CashierMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierMenu frame = new CashierMenu();
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
	public CashierMenu() {
		setTitle("Cashier Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 753);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(203, 203, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create Bill");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		// Remove the border
		btnNewButton.setBorderPainted(false);

		// Remove the focus border (dashed line when clicked)
		btnNewButton.setFocusPainted(false);

		// Remove the background fill effect
		btnNewButton.setContentAreaFilled(false);

		// Optional: Set a transparent background (if needed)
		btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                NewBill newbill = new NewBill(); // Create instance of Page2
                newbill.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton.setBounds(538, 174, 235, 61);
		contentPane.add(btnNewButton);
		
		JButton btnSearchBill = new JButton("Search Bill");
		// Remove the border
		btnSearchBill.setBorderPainted(false);

		// Remove the focus border (dashed line when clicked)
		btnSearchBill.setFocusPainted(false);

		// Remove the background fill effect
		btnSearchBill.setContentAreaFilled(false);

		// Optional: Set a transparent background (if needed)
		btnSearchBill.setOpaque(false);
		btnSearchBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                SearchBill searchbill = new SearchBill(); // Create instance of Page2
                searchbill.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnSearchBill.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSearchBill.setBounds(538, 277, 235, 61);
		contentPane.add(btnSearchBill);
		
		JButton btnNewButton_1_1 = new JButton("Sales");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		// Remove the border
		btnNewButton_1_1.setBorderPainted(false);

		// Remove the focus border (dashed line when clicked)
		btnNewButton_1_1.setFocusPainted(false);

		// Remove the background fill effect
		btnNewButton_1_1.setContentAreaFilled(false);

		// Optional: Set a transparent background (if needed)
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(538, 489, 235, 61);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Exit");
		// Remove the border
		btnNewButton_1_1_1.setBorderPainted(false);

		// Remove the focus border (dashed line when clicked)
		btnNewButton_1_1_1.setFocusPainted(false);

		// Remove the background fill effect
		btnNewButton_1_1_1.setContentAreaFilled(false);

		// Optional: Set a transparent background (if needed)
		btnNewButton_1_1_1.setOpaque(false);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                CashierLogin cashierLogin = new CashierLogin(); // Create instance of Page2
                cashierLogin.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_1_1_1.setBounds(538, 603, 235, 61);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Product Information");
		// Remove the border
		btnNewButton_1_1_1_1.setBorderPainted(false);

		// Remove the focus border (dashed line when clicked)
		btnNewButton_1_1_1_1.setFocusPainted(false);

		// Remove the background fill effect
		btnNewButton_1_1_1_1.setContentAreaFilled(false);

		// Optional: Set a transparent background (if needed)
		btnNewButton_1_1_1_1.setOpaque(false);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                ProductInformation productInformation = new ProductInformation(); // Create instance of Page2
                productInformation.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
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
                CashierLogin cashierLogin = new CashierLogin(); // Create instance of Page2
                cashierLogin.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(10, 652, 125, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");

		// Load original icon
		ImageIcon originalIcon = new ImageIcon(CashierMenu.class.getResource("/images/search.png")); 

		// Resize the icon to fit JLabel
		Image img = originalIcon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH); // Match JLabel size
		ImageIcon resizedIcon = new ImageIcon(img);

		// Set the resized icon to the JLabel
		lblNewLabel_2.setIcon(resizedIcon);

		// Set label properties
		lblNewLabel_2.setHorizontalTextPosition(JLabel.CENTER);  // Text below icon
		lblNewLabel_2.setVerticalTextPosition(JLabel.BOTTOM);  
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);     // Center everything
		lblNewLabel_2.setVerticalAlignment(JLabel.CENTER);
		lblNewLabel_2.setBounds(534, 277, 86, 73);  // Ensure JLabel is the same size as icon

		// Add label to content pane
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		

		// Load original icon
		ImageIcon originalIcon2 = new ImageIcon(CashierMenu.class.getResource("/images/add.png")); 

		// Resize the icon to fit JLabel
		Image img2 = originalIcon2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH); // Match JLabel size
		ImageIcon resizedIcon2 = new ImageIcon(img2);

		// Set the resized icon to the JLabel
		lblNewLabel_2_1.setIcon(resizedIcon2);

		// Set label properties
		lblNewLabel_2_1.setHorizontalTextPosition(JLabel.CENTER);  // Text below icon
		lblNewLabel_2_1.setVerticalTextPosition(JLabel.BOTTOM);  
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);     // Center everything
		lblNewLabel_2_1.setVerticalAlignment(JLabel.CENTER);
		lblNewLabel_2_1.setBounds(534, 174, 86, 73);  // Ensure JLabel is the same size as icon

		// Add label to content pane
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		

		// Load original icon
		ImageIcon originalIcon3 = new ImageIcon(CashierMenu.class.getResource("/images/products.png")); 

		// Resize the icon to fit JLabel
		Image img3 = originalIcon3.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH); // Match JLabel size
		ImageIcon resizedIcon3 = new ImageIcon(img3);

		// Set the resized icon to the JLabel
		lblNewLabel_2_1_1.setIcon(resizedIcon3);

		// Set label properties
		lblNewLabel_2_1_1.setHorizontalTextPosition(JLabel.CENTER);  // Text below icon
		lblNewLabel_2_1_1.setVerticalTextPosition(JLabel.BOTTOM);  
		lblNewLabel_2_1_1.setHorizontalAlignment(JLabel.CENTER);     // Center everything
		lblNewLabel_2_1_1.setVerticalAlignment(JLabel.CENTER);
		lblNewLabel_2_1_1.setBounds(489, 388, 86, 73);  // Ensure JLabel is the same size as icon

		// Add label to content pane
		contentPane.add(lblNewLabel_2_1_1);

	}
}
