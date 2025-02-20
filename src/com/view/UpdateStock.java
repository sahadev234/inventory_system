package com.view;

import java.awt.EventQueue;
import com.model.*;
import com.service.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.service.ProductService;
import com.service.ProductServiceImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField nameTxt;
	private JTextField avbl;
	private JTextField qadd;
	private JTextField mp;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStock frame = new UpdateStock();
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
	public UpdateStock() {
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1333, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(155, 173, 181, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProductName.setBounds(155, 245, 181, 30);
		contentPane.add(lblProductName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity Available");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(155, 313, 181, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantity Added");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(155, 387, 181, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mrp");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(155, 462, 181, 30);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int productId=Integer.parseInt(pid.getText());
				String productName=nameTxt.getText();
				int available=Integer.parseInt(avbl.getText());
				int mrp=Integer.parseInt(mp.getText());
				
				ProductService service=new ProductServiceImpl();
				Product p=new Product();
				p.setProductId(productId);
				p.setProductName(productName);
				p.setAvailable(available);
				p.setMrp(mrp);
				service.addProduct(p);
				qadd.setEnabled(false);
				display();
				clearForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(155, 539, 115, 48);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int productId=Integer.parseInt(pid.getText());
				String productName=nameTxt.getText();
				int available=Integer.parseInt(qadd.getText());
				int mrp=Integer.parseInt(mp.getText());
				ProductService service=new ProductServiceImpl();
				Product p=new Product();
				p.setProductId(productId);
				p.setProductName(productName);
				p.setAvailable(available);
				p.setMrp(mrp);
				service.updateProduct(p);
				avbl.setEnabled(true);
				qadd.setEnabled(false);
				display();
				btnUpdate.setEnabled(false);
				clearForm();
				
				
				
						
			}

		
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnUpdate.setBounds(374, 539, 115, 48);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_2 = new JLabel("Update Stock");
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
		
		avbl = new JTextField();
		avbl.setColumns(10);
		avbl.setBounds(389, 315, 211, 35);
		contentPane.add(avbl);
		
		qadd = new JTextField();
		qadd.setColumns(10);
		qadd.setBounds(389, 389, 211, 35);
		contentPane.add(qadd);
		
		mp = new JTextField();
		mp.setColumns(10);
		mp.setBounds(389, 457, 211, 35);
		contentPane.add(mp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 53, 638, 588);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product  ID", "Product Name", "Available", "Mrp"
			}
		));
		scrollPane.setViewportView(table);
		
		if(table.getSelectedRow()>0) {
			btnNewButton.setEnabled(false);
		}
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int srow=table.getSelectedRow();
				qadd.setEnabled(true);
				btnUpdate.setEnabled(true);
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"select any row");
				}
				
				pid.setText(table.getModel().getValueAt(srow,0).toString());
				nameTxt.setText(table.getModel().getValueAt(srow,1).toString());
				avbl.setText(table.getModel().getValueAt(srow,2).toString());
				mp.setText(table.getModel().getValueAt(srow,3).toString());
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnEdit.setBounds(922, 645, 115, 48);
		contentPane.add(btnEdit);
		display();
		qadd.setEnabled(false);
		btnUpdate.setEnabled(false);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                AdminMenu page2 = new AdminMenu(); // Create instance of Page2
                page2.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(10, 645, 89, 48);
		contentPane.add(btnNewButton_1);
	}
	public void display() {
		ProductService service=new ProductServiceImpl();
		List<Product> plist=service.getAllProduct();
		DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Product pd:plist) {
			tmodel.addRow(new Object[] {pd.getProductId(),pd.getProductName(),pd.getAvailable(),pd.getMrp()});
		}
	}
	public void clearForm() {
		//clear input form
		pid.setText("");
		nameTxt.setText("");
		avbl.setText("");
		mp.setText("");
		qadd.setText("");
	}
	
}
