package com.view;
import com.view.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;
import com.model.Product;
import com.service.CashierService;
import com.service.CashierServiceImpl;

public class AddCashier extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField nameTxt;
	private JTextField moNoTxt;
	private JTextField addressTxt;
	private JTextField emailTxt;
	private JTable table;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	public AddCashier() {
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1333, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(155, 173, 181, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Name");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProductName.setBounds(155, 245, 181, 30);
		contentPane.add(lblProductName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mno");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(155, 313, 181, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(155, 387, 181, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(155, 462, 181, 30);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				int cashierId=Integer.parseInt(pid.getText());
				String cashierName=nameTxt.getText();
				String mobileNumber=moNoTxt.getText();
				String address=addressTxt.getText();
				String email=emailTxt.getText();
				String password=passwordTxt.getText();
				
				CashierService service=new CashierServiceImpl();
				Cashier c=new Cashier();
				c.setCashierId(cashierId);
				c.setCashierName(cashierName);
				c.setMobileNumber(mobileNumber);
				c.setAddress(address);
				c.setEmailId(email);
				c.setPassword(password);
				
				service.addCashier(c);
				
				display();
				clearForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(106, 593, 115, 48);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cashierId=Integer.parseInt(pid.getText());
				String cashierName=nameTxt.getText();
				String mobileNumber=moNoTxt.getText();
				String address=addressTxt.getText();
				String email=emailTxt.getText();
				String password=passwordTxt.getText();
				CashierService service=new CashierServiceImpl();
				Cashier c=new Cashier();
				c.setCashierId(cashierId);
				c.setCashierName(cashierName);
				c.setMobileNumber(mobileNumber);
				c.setAddress(address);
				c.setEmailId(email);
				c.setPassword(password);
				service.updateCashier(c);
				moNoTxt.setEnabled(true);
				addressTxt.setEnabled(false);
				display();
				btnUpdate.setEnabled(false);
				clearForm();
				
				
				
						
			}

		
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnUpdate.setBounds(314, 593, 115, 48);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_2 = new JLabel("Add Cashier Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(206, 53, 323, 68);
		contentPane.add(lblNewLabel_2);
		
		pid = new JTextField();
		pid.setBounds(389, 175, 211, 35);
		contentPane.add(pid);
		pid.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		nameTxt.setBounds(389, 247, 211, 35);
		contentPane.add(nameTxt);
		
		moNoTxt = new JTextField();
		moNoTxt.setColumns(10);
		moNoTxt.setBounds(389, 315, 211, 35);
		contentPane.add(moNoTxt);
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		addressTxt.setBounds(389, 389, 211, 35);
		contentPane.add(addressTxt);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(389, 457, 211, 35);
		contentPane.add(emailTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 53, 638, 588);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "Mno", "address","email","password"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int srow=table.getSelectedRow();
				
				
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"select any row");
					return;
				}
				
				pid.setText(table.getModel().getValueAt(srow,0).toString());
				nameTxt.setText(table.getModel().getValueAt(srow,1).toString());
				moNoTxt.setText(table.getModel().getValueAt(srow,2).toString());
				addressTxt.setText(table.getModel().getValueAt(srow,3).toString());
				emailTxt.setText(table.getModel().getValueAt(srow,4).toString());
				passwordTxt.setText(table.getModel().getValueAt(srow,5).toString());
				btnUpdate.setEnabled(true);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnEdit.setBounds(922, 645, 115, 48);
		contentPane.add(btnEdit);
		display();
	
		btnUpdate.setEnabled(false);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(155, 536, 181, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(389, 531, 211, 35);
		contentPane.add(passwordTxt);
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"select any row");
					return;
				}
				int srow=table.getSelectedRowCount();
				int cashierId= Integer.parseInt(table.getModel().getValueAt(srow,0).toString());
				CashierService service=new CashierServiceImpl();
				service.deleteCashier(cashierId);
				display();
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDelete.setBounds(485, 593, 115, 48);
		
		btnDelete.setEnabled(true);
		contentPane.add(btnDelete);
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                AdminMenu adminMenu = new AdminMenu(); // Create instance of Page2
                adminMenu.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(0, 658, 89, 35);
		contentPane.add(btnNewButton_1);
		
	}

	public void display() {
		CashierService service=new CashierServiceImpl();
		List<Cashier> clist=service.getAllCashier();
		DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Cashier pd:clist) {
			tmodel.addRow(new Object[] {pd.getCashierId(),pd.getCashierName(),pd.getMobileNumber(),pd.getAddress(),pd.getEmailId(),pd.getPassword()});
		}
	}
	public void clearForm() {
		//clear input form
		pid.setText("");
		nameTxt.setText("");
		moNoTxt.setText("");
		addressTxt.setText("");
		emailTxt.setText("");
		passwordTxt.setText("");
	
	}
}