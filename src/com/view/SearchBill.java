package com.view;
import com.model.*;
import com.service.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchedTxt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
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
	public SearchBill() {
		
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 726);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Bill");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(497, 21, 232, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bill No:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(337, 109, 89, 38);
		contentPane.add(lblNewLabel_1);
		
		searchedTxt = new JTextField();
		searchedTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text=searchedTxt.getText().trim();
				 // Handle empty input
		        if (text.isEmpty()) {
		            ((DefaultTableModel) table.getModel()).setRowCount(0); // Clear table
		            return;
		        }
				int searchBillNo= Integer.parseInt(searchedTxt.getText().trim());
				BillService service=new BillServiceImpl();
				List<Bill>blist=service.searchBill(searchBillNo);
				
				DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
				tmodel.setRowCount(0);
				
				for(Bill bl:blist) {
					tmodel.addRow(new Object[] {bl.getBillNo(),bl.getCustomerName(),bl.getAmount(),bl.getDate()});
				}
			}
		});
		searchedTxt.setBounds(457, 111, 187, 42);
		contentPane.add(searchedTxt);
		searchedTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("         Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(773, 111, 155, 42);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(262, 178, 757, 410);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Billno", "Customer Name", "Amount", "Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton(" Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                CashierMenu cashierMenu = new CashierMenu(); // Create instance of Page2
                cashierMenu.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(10, 636, 89, 42);
		contentPane.add(btnNewButton_1);
		displayData();
	}
	public void displayData() {
		BillService service=new BillServiceImpl();
		List<Bill> blist=service.getAllBill();
	
		
		DefaultTableModel tmodel= (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Bill bl:blist) {
			tmodel.addRow(new Object[] {bl.getBillNo(),bl.getCustomerName(),bl.getAmount(),bl.getDate()});
		}
		
	}
}
