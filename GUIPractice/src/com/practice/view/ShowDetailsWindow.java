package com.practice.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.practice.controller.DBHelper;
import com.practice.model.Customer;

public class ShowDetailsWindow {
	JFrame detailsFr;
	JTable table;
	JScrollPane scrollPane;
	ArrayList<Customer> customerList;
	Customer cRef;
	String [][] customerListArray;
	String [] column= {"Customer ID","Name","Phone Number","eMail"};
	
	public void createShowDetailsWindow() {
		detailsFr = new JFrame("Customer Details");
		table = new JTable(customerListArray,column);
		scrollPane = new JScrollPane(table);
		
		
	}
	public void showDetailsFrame() {   
		detailsFr.add(scrollPane);
		detailsFr.setSize(600,500);
		detailsFr.setVisible(true);
	}
	
	public void getData() {
		DBHelper db= new DBHelper();
		db.createConnection();
		customerList = db.fetchCustomersFromDB();
		db.closeConnection();
		int sizeOfCustomerList=customerList.size();
		int numOfColumns=4;
		customerListArray= new String[sizeOfCustomerList][numOfColumns];
		
		//String [] column= {"Customer ID","Name","Phone Number","eMail"};
		
		for(int i=0;i<sizeOfCustomerList;i++) {
			cRef=customerList.get(i);
			customerListArray[i][0]=Integer.toString(cRef.cid);
			customerListArray[i][1]=cRef.name;
			customerListArray[i][2]=cRef.phone;
			customerListArray[i][3]=cRef.email;			
		}
		
	}
}
