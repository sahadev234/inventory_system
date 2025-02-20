package com.view;

import java.awt.EventQueue;
import com.model.*;
import com.service.*;
import com.service.BillService;
import com.service.BillServiceImpl;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class NewBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel nameTxt;
	private JTextField bno;
	private JTextField ctnmTxt;
	private JTextField nm;
	private JTextField mp;
	private JTextField qty;
	private JTextField dct;
	private JTable table;
	private JTextField totalTxt;
	private JTextField dt;
	private JComboBox<Integer> productCmb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill frame = new NewBill();
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
	public NewBill() {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1314, 746);
		nameTxt = new JPanel();
		nameTxt.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(nameTxt);
		nameTxt.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(191, 40, 181, 30);
		nameTxt.add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer Name:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerId.setBounds(191, 106, 181, 30);
		nameTxt.add(lblCustomerId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(191, 173, 181, 30);
		nameTxt.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(191, 237, 181, 30);
		nameTxt.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mrp");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(191, 314, 181, 30);
		nameTxt.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(191, 396, 181, 30);
		nameTxt.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Discount");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(191, 470, 181, 30);
		nameTxt.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int billNo=Integer.parseInt(bno.getText());
				String customerNameTxt=ctnmTxt.getText();
			    int	discount=Integer.parseInt(dct.getText());
			    String date=dt.getText();
			    int quantity=Integer.parseInt(qty.getText());
			    String name=nm.getText();
			    int mrp=Integer.parseInt(mp.getText());
			    int productId= Integer.parseInt(productCmb.getSelectedItem().toString());
			    
			    
			    int totalPrice=quantity*mrp;
				   int discountAmount=(int)((totalPrice)*(discount/100.0));
				   int amount=totalPrice-discountAmount;
				   
			    
			    Bill b=new Bill();
			    BillService service= new BillServiceImpl();
			    b.setBillNo(billNo);
			    b.setCustomerName(customerNameTxt);
			    b.setAmount(amount);
			    b.setDate(date);
			    
			    service.addBill(b);
			    
			    ProductService pservice=new ProductServiceImpl();
			    pservice.updateProduct(quantity, productId);
			    
			    JOptionPane.showMessageDialog(null, "bill added success");
			    
			    totalTxt.setText(String.valueOf(amount));

			    displayData(quantity,name,mrp);
			    
			    
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(175, 547, 115, 48);
		nameTxt.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(399, 547, 115, 48);
		nameTxt.add(btnNewButton_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(751, 40, 181, 30);
		nameTxt.add(lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(715, 108, 531, 450);
		nameTxt.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Quantity", "Name", "Mrp", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(805, 592, 181, 30);
		nameTxt.add(lblNewLabel_2_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(897, 645, 89, 42);
		nameTxt.add(btnNewButton_2);
		
		bno = new JTextField();
		bno.setBounds(359, 42, 144, 35);
		nameTxt.add(bno);
		bno.setColumns(10);
		
		ctnmTxt = new JTextField();
		ctnmTxt.setColumns(10);
		ctnmTxt.setBounds(359, 108, 211, 35);
		nameTxt.add(ctnmTxt);
		
		nm = new JTextField();
		nm.setColumns(10);
		nm.setBounds(359, 239, 211, 35);
		nameTxt.add(nm);
		
		mp = new JTextField();
		mp.setColumns(10);
		mp.setBounds(359, 316, 211, 35);
		nameTxt.add(mp);
		
		qty = new JTextField();
		qty.setColumns(10);
		qty.setBounds(359, 398, 211, 35);
		nameTxt.add(qty);
		
		dct = new JTextField();
		dct.setColumns(10);
		dct.setBounds(359, 472, 211, 35);
		nameTxt.add(dct);
		
		productCmb = new JComboBox<Integer>();
		 productCmb.setFont(new Font("Tahoma", Font.PLAIN, 20));
	       loadProductIds();
	       productCmb.setBounds(359, 169, 211, 38);
		nameTxt.add(productCmb);
		
		
		
		
		totalTxt = new JTextField();
		totalTxt.setColumns(10);
		totalTxt.setBounds(957, 587, 211, 35);
		nameTxt.add(totalTxt);
		
		dt = new JTextField();
		dt.setColumns(10);
		dt.setBounds(842, 35, 211, 35);
		nameTxt.add(dt);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Page 2 when button is clicked
                CashierMenu cashierMenu = new CashierMenu(); // Create instance of Page2
                cashierMenu.setVisible(true); // Make Page2 visible
                setVisible(false); // Hide Page1
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(10, 663, 89, 35);
		nameTxt.add(btnNewButton_3);
	}
	private void displayData(int quantity,String name,int mrp) {
		
		
		DefaultTableModel tmodel= (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		
			tmodel.addRow(new Object[] {quantity,name,mrp,1000});
		
	}
	private void loadProductIds() {
		
		ProductService service=new ProductServiceImpl();
        List<Integer> plist=service.getProductIds();
        
        for(Integer id:plist) {
          productCmb.addItem(id);
        }
	}
}
