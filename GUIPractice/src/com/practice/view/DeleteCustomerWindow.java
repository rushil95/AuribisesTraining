package com.practice.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.practice.controller.DBHelper;

public class DeleteCustomerWindow implements ActionListener {
	JFrame deleteFrame;
	
	JPanel panelAll;
	JPanel panelTitle;
	JPanel panelAskId;
	JPanel panelDeleteButton;
	
	JLabel labelTitle;
	JLabel labelAskId;
	
	JButton buttonDelete;
	
	JTextField txtId;
	
	DeleteCustomerWindow(){
		
		deleteFrame = new JFrame();
		
		panelAll = new JPanel();
		panelTitle = new JPanel();
		panelAskId = new JPanel();
		panelDeleteButton = new JPanel();
		
		labelTitle = new JLabel("Delete Customer");
		labelAskId = new JLabel("Enter Customer ID");
		
		buttonDelete = new JButton("Delete Customer");
		buttonDelete.addActionListener(this);
		
		txtId = new JTextField(16);		
	}
	
	public void ShowDeleteCustomerWindow() {
		
		panelTitle.add(labelTitle);
		panelAskId.add(labelAskId);
		panelAskId.add(txtId);
		panelDeleteButton.add(buttonDelete);
		panelAll.add(panelTitle);
		panelAll.add(panelAskId);
		panelAll.add(panelDeleteButton);
		
		GridLayout layout = new GridLayout(4,1);
		panelAll.setLayout(layout);
		
		deleteFrame.add(panelAll);
		deleteFrame.setSize(400,400);
		deleteFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonDelete) {
			int cid= Integer.parseInt(txtId.getText());
			DBHelper DB = new DBHelper();
			DB.createConnection();
			System.out.println(cid);
			DB.deleteCustomerFromDB(cid);
			DB.closeConnection();
		}
		
	}
	
}
