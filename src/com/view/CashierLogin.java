package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.model.*;
import com.service.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.service.AdminService;
import com.service.AdminServiceImpl;

public class CashierLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setTitle("Login");
		setBackground(new Color(255, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 62, 82));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(326, 234, 165, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(326, 332, 165, 48);
		contentPane.add(lblNewLabel_1);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(501, 238, 221, 48);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(429, 447, 136, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=usernameTxt.getText().trim();
				String password=passwordTxt.getText().trim();
				
				CashierService service=new CashierServiceImpl();
				if(service.verifyCashier(email,password)) {
					
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect username or password");
					return;
				}
				// Open Page 2 when button is clicked
                CashierMenu cashiermenu = new CashierMenu(); // Create instance of Page2
                cashiermenu.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
	
				
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(646, 447, 136, 55);
		contentPane.add(btnNewButton_1);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(501, 336, 221, 48);
		contentPane.add(passwordTxt);
		
		JButton btnNewButton_2 = new JButton("Click here to create new account");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		// Remove the border
				btnNewButton_2.setBorderPainted(false);

				// Remove the focus border (dashed line when clicked)
				btnNewButton_2.setFocusPainted(false);

				// Remove the background fill effect
				btnNewButton_2.setContentAreaFilled(false);

				// Optional: Set a transparent background (if needed)
				btnNewButton_2.setOpaque(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(471, 574, 326, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Cashier Login");
		lblNewLabel_2.setForeground(new Color(0, 255, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(546, 80, 347, 82);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                WelcomePage welcomepage = new WelcomePage(); // Create instance of Page2
                welcomepage.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(30, 612, 145, 48);
		contentPane.add(btnNewButton_3);
	}

}
