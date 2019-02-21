package com.practice.view;

//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.practice.controller.DBHelper;
import com.practice.model.Customer;

public class UpdateCustomerDataWindow implements ActionListener{
	
	Customer cRef;
	JFrame updateFrame;
	JLabel labelTitle,labelName,labelPhone,labelEmail,labelAskId;
	JTextField txtName,txtPhone,txtEmail,txtId;
	JPanel panelAll,panelTitle,panelAskId,panelAskIdButton,panelName,panelPhone,panelEmail,panelBtn,panelCustomerDetailsBtn,panelUpdateButton;
	JButton buttonId,buttonUpdateDetails;
	//JButton btnUpdateCustomerDetails;
	
	public UpdateCustomerDataWindow() {
		updateFrame = new JFrame("Update Customer Details");
		panelTitle = new JPanel();
		panelAskId = new JPanel();
		panelAskIdButton = new JPanel();
		panelName = new JPanel();
		panelPhone = new JPanel();
		panelEmail = new JPanel();
		panelUpdateButton = new JPanel();
		panelAll = new JPanel();
		
		labelTitle = new JLabel("Update Customer Details");
		labelAskId = new JLabel("Enter Customer ID ");
		labelName = new JLabel("Enter Customer Name");
		labelPhone = new JLabel("Enter Customer  Phone");
		labelEmail = new JLabel("Enter Customer Email");
		
		txtId = new JTextField(16);
		txtName = new JTextField(16);
		txtPhone = new JTextField(16);
		txtEmail = new JTextField(16);
		
		buttonId = new JButton("OK");
		buttonId.addActionListener(this);
		buttonUpdateDetails = new JButton("Update");
		buttonUpdateDetails.addActionListener(this);
							
	}
	
	public void ShowUpdateCustomerWindow() {
		//updateFrame.add(panelTitle);
		panelTitle.add(labelTitle);
		panelAskId.add(labelAskId);
		panelAskId.add(txtId);
		panelAskIdButton.add(buttonId);
		panelName.add(labelName);
		panelName.add(txtName);
		panelPhone.add(labelPhone);
		panelPhone.add(txtPhone);
		panelEmail.add(labelEmail);
		panelEmail.add(txtEmail);
		panelUpdateButton.add(buttonUpdateDetails);
		
		panelAll.add(panelTitle);
		panelAll.add(panelAskId);
		panelAll.add(panelAskIdButton);
		panelAll.add(panelName);
		panelAll.add(panelPhone);
		panelAll.add(panelEmail);
		panelAll.add(panelUpdateButton);
		
		
		updateFrame.add(panelAll);
		
		updateFrame.setSize(400, 400);
		updateFrame.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==buttonId) {
			int cid=Integer.parseInt(txtId.getText());
			DBHelper db = new DBHelper();
			db.createConnection();
			Customer cRef=db.fetchSingleCustomer(cid);
			txtName.setText(cRef.name);
			txtPhone.setText(cRef.phone);
			txtEmail.setText(cRef.email);
			db.closeConnection();
								
		}
		
		if(e.getSource()==buttonUpdateDetails) {
			Customer cRef= new Customer();
			cRef.cid=Integer.parseInt(txtId.getText());
			cRef.name=txtName.getText();
			cRef.phone=txtPhone.getText();
			cRef.email=txtEmail.getText();
			System.out.println(cRef);
			DBHelper db = new DBHelper();
			db.createConnection();
			db.UpdateCustomerDataInDB(cRef);
			db.closeConnection();
			
			
		}
		
	}
}
