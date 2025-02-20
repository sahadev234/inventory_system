package com.view;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import com.model.*;
import com.service.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class RegisterForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameTxt;
	private JTextField lastNameTxt;
	private JTextField usernameTxt;
	private JTextField addressTxt;
	private JPasswordField passwordTxt;
	private JPasswordField retypePassTxt;
	private JSpinner dobTxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1314, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(44, 62, 82));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel FirstName = new JLabel("First Name:");
		FirstName.setForeground(new Color(255, 255, 255));
		FirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FirstName.setBounds(128, 31, 181, 30);
		contentPane.add(FirstName);
		
		JLabel LastName = new JLabel("Last Name:");
		LastName.setForeground(Color.WHITE);
		LastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LastName.setBounds(128, 104, 181, 30);
		contentPane.add(LastName);
		
		JLabel Username = new JLabel("UserName:");
		Username.setForeground(Color.WHITE);
		Username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Username.setBounds(128, 174, 181, 30);
		contentPane.add(Username);
		
		JLabel Password = new JLabel("Password:");
		Password.setForeground(Color.WHITE);
		Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password.setBounds(128, 242, 181, 30);
		contentPane.add(Password);
		
		JLabel RetypePass = new JLabel("Retype Pass:");
		RetypePass.setForeground(Color.WHITE);
		RetypePass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RetypePass.setBounds(128, 318, 181, 30);
		contentPane.add(RetypePass);
		
		JLabel BirthDate = new JLabel("BirthDate:");
		BirthDate.setForeground(Color.WHITE);
		BirthDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BirthDate.setBounds(128, 392, 181, 30);
		contentPane.add(BirthDate);
		
		JLabel Address = new JLabel("Address:");
		Address.setForeground(Color.WHITE);
		Address.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Address.setBounds(128, 467, 181, 30);
		contentPane.add(Address);
		
		firstNameTxt = new JTextField();
		firstNameTxt.setBackground(new Color(236, 240, 241));
		firstNameTxt.setBounds(333, 31, 331, 38);
		contentPane.add(firstNameTxt);
		firstNameTxt.setColumns(10);
		
		lastNameTxt = new JTextField();
		lastNameTxt.setColumns(10);
		lastNameTxt.setBounds(333, 104, 331, 38);
		contentPane.add(lastNameTxt);
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(333, 174, 331, 38);
		contentPane.add(usernameTxt);
		
		addressTxt = new JTextField();
		addressTxt.setBackground(new Color(82, 103, 109));
		addressTxt.setColumns(10);
		addressTxt.setBounds(332, 446, 464, 81);
		contentPane.add(addressTxt);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(333, 242, 331, 38);
		contentPane.add(passwordTxt);
		
		retypePassTxt = new JPasswordField();
		retypePassTxt.setBackground(new Color(255, 255, 255));
		retypePassTxt.setBounds(333, 310, 331, 38);
		contentPane.add(retypePassTxt);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNameTxt.setText("");
				lastNameTxt.setText("");
				usernameTxt.setText("");
				passwordTxt.setText("");
				addressTxt.setText("");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(253, 569, 135, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname=firstNameTxt.getText();
				String lastname=lastNameTxt.getText();
				String username=usernameTxt.getText();
				String password=passwordTxt.getText();
				String rePassword=retypePassTxt.getText();
				// Get the selected date from the spinner
				Date selectedDate = (Date) dobTxt.getValue();
				String date=selectedDate.toString();

				// Format the date as a string (yyyy-MM-dd format)
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateText = sdf.format(selectedDate);
				String address=addressTxt.getText();
				if(passwordTxt.getText().equals(retypePassTxt.getText())) {
					JOptionPane.showMessageDialog(null, "Registration Succesfull");
					firstNameTxt.setText("");
					lastNameTxt.setText("");
					usernameTxt.setText("");
					passwordTxt.setText("");
					addressTxt.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null,"Password do not match");
					retypePassTxt.setText("!Error password doesn't match with the above one");
					return;
				}
				
				AdminService service=new AdminServiceImpl();
				Admin a=new Admin();
				a.setFirstName(firstname);
				a.setLastName(lastname);
				a.setUsername(username);
				a.setPassword(password);
				a.setDob(date);
				a.setAddress(address);
				service.addAdmin(a);
				
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(542, 569, 135, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Click here to login");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
				// Open Page 2 when button is clicked
                LoginForm loginform = new LoginForm(); // Create instance of Page2
                loginform.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_2.setBounds(383, 636, 215, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("Select DOB:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(128, 392, 181, 30); // Positioning the label
		contentPane.add(label);

		dobTxt = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.YEAR));
		JSpinner.DateEditor de_dobTxt = new JSpinner.DateEditor(dobTxt, "yyyy-MM-dd");
		dobTxt.setEditor(de_dobTxt);
		dobTxt.setBounds(333, 384, 331, 38); // Positioning the spinner
		contentPane.add(dobTxt);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                WelcomePage welcomePage = new WelcomePage(); // Create instance of Page2
                welcomePage.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(10, 636, 89, 35);
		contentPane.add(btnNewButton_3);

		
	}
}
