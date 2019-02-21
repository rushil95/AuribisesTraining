package com.practice.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.practice.controller.DBHelper;
import com.practice.model.Customer;

public class AddCustomerWindow implements ActionListener {
	JFrame fr,showDetailsFrame;
	JLabel labelTitle,labelName,labelPhone,labelEmail;
	JTextField txtName,txtPhone,txtEmail;
	JPanel panelAll,panelTitle,panelName,panelPhone,panelEmail,panelBtn,
	panelCustomerDetailsBtn,panelDeleteCustomerBtn,panelUpdateDetailsBtn;
	JButton btnAddCustomer;
	JButton btnDeleteCustomer;
	JButton btnViewCustomerDetails;
	JButton btnUpdateDetails;
	
	ArrayList <Customer> customerList=new ArrayList<Customer>();
	
	public AddCustomerWindow() {
		fr = new JFrame("Add Customer Details");
		showDetailsFrame = new JFrame("Customers Details");
		
		labelTitle = new JLabel("Enter Customer Details");
		labelName = new JLabel("Enter Customer Name");
		labelPhone = new JLabel("Enter Customer Phone");
		labelEmail = new JLabel("Enter Customer Email");
		
		txtEmail=new JTextField(16);
		txtPhone=new JTextField(16);
		txtName=new JTextField(16);
		
		panelAll=new JPanel();
		panelEmail=new JPanel();
		panelName=new JPanel();
		panelPhone=new JPanel();
		panelTitle=new JPanel();
		panelBtn=new JPanel();
		panelCustomerDetailsBtn = new JPanel();
		panelUpdateDetailsBtn = new JPanel();
		panelDeleteCustomerBtn = new JPanel();

		
		btnAddCustomer=new JButton("Add Customer");
		btnAddCustomer.addActionListener(this);
		btnViewCustomerDetails= new JButton("View Customer Details");
		btnViewCustomerDetails.addActionListener(this);
		btnUpdateDetails = new JButton("Update Customer Details");
		btnUpdateDetails.addActionListener(this);
		btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(this);
		
		
	}
	
	public void showWindow(){
		
		panelTitle.add(labelTitle);
		
		panelName.add(labelName);
		panelName.add(txtName);
		
		panelPhone.add(labelPhone);
		panelPhone.add(txtPhone);
		
		panelEmail.add(labelEmail);
		panelEmail.add(txtEmail);
		
		panelBtn.add(btnAddCustomer);
		panelCustomerDetailsBtn.add(btnViewCustomerDetails);		
		panelUpdateDetailsBtn.add(btnUpdateDetails);
		panelDeleteCustomerBtn.add(btnDeleteCustomer);
		
		panelAll.add(panelTitle);
		panelAll.add(panelName);
		panelAll.add(panelPhone);
		panelAll.add(panelEmail);
		panelAll.add(panelBtn);
		panelAll.add(panelCustomerDetailsBtn);
		panelAll.add(panelUpdateDetailsBtn);
		panelAll.add(panelDeleteCustomerBtn);
		
		
		GridLayout layout = new GridLayout(8,1);
		panelAll.setLayout(layout);
		
		fr.add(panelAll);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fr.setSize(500, 500);
		fr.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAddCustomer) {
			Customer cRef = new Customer();
			cRef.name=txtName.getText();
			cRef.phone=txtPhone.getText();
			cRef.email=txtEmail.getText();
			
			DBHelper db = new DBHelper();
			db.createConnection();
			int i= db.addCustomerInDB(cRef);
			db.closeConnection();
			

			if(i>0){
				System.out.println(">> "+cRef.name+" Added");
				txtName.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
			}else{
				System.out.println(">> "+cRef.name+" Not Added");
			}
		}
		
		//Open a new Window on button Click
		if(e.getSource()==btnViewCustomerDetails) {
			ShowDetailsWindow detailsRef = new ShowDetailsWindow();
			detailsRef.getData();
			detailsRef.createShowDetailsWindow();
			detailsRef.showDetailsFrame();
		}
		if(e.getSource()==btnUpdateDetails) {
			UpdateCustomerDataWindow updateWindow = new UpdateCustomerDataWindow();
			updateWindow.ShowUpdateCustomerWindow();
		}
		
		if(e.getSource()==btnDeleteCustomer) {
			DeleteCustomerWindow deleteWindow = new DeleteCustomerWindow();
			deleteWindow.ShowDeleteCustomerWindow();
		}
	}	

}
