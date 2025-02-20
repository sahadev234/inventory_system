package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setTitle("Welcome Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 757);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(203, 203, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome To SuperMarket Biling System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton(" Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                 LoginForm loginForm = new LoginForm(); // Create instance of Page2
                loginForm.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JButton btnCashierLogin = new JButton("Cashier Login");
		btnCashierLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                CashierLogin cashierLogin = new CashierLogin(); // Create instance of Page2
                cashierLogin.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnCashierLogin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(WelcomePage.class.getResource("/images/Screenshot (22).png")));
		
		JLabel lblNewLabel_2 = new JLabel("Quick Bill");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(382)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(369)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
									.addGap(409))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
									.addGap(373)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCashierLogin, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCashierLogin, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))))
					.addGap(246))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
