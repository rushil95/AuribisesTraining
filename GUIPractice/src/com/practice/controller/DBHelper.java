package com.practice.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.practice.model.Customer;

public class DBHelper {
		Connection con;
		PreparedStatement pStmt;
		
		//Load Drivers
		public DBHelper(){
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//Create Connection
		public void createConnection() {
			try {
				String url="jdbc:mysql://localhost/database1";
				String user="root";
				String password="";
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Connection Created");
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
		}
		
	
		public int addCustomerInDB(Customer cRef){
			
			int i = 0;
			
			try {
				
				
				String sql = "insert into customer values(null, ?, ?, ?)";
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1, cRef.name);
				pStmt.setString(2, cRef.phone);
				pStmt.setString(3, cRef.email);
				
				i = pStmt.executeUpdate();
				if(i>0) {
					System.out.println(cRef.name+" added to Database");
				}else {
					System.out.println(cRef.name+" not Added");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return i;
		}
		
		public Customer fetchSingleCustomer(int id) {
			Customer cRef = new Customer();
			try {
				String sql="select * from customer where cid="+id+"";
				pStmt=con.prepareStatement(sql);
				ResultSet rs=pStmt.executeQuery();
				while(rs.next()) {
					cRef.cid=rs.getInt(1);
					cRef.name=rs.getString(2);
					cRef.phone=rs.getString(3);
					cRef.email=rs.getString(4);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return cRef;
		}
		
		// returns Customers as ArayList
		public ArrayList<Customer> fetchCustomersFromDB(){
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			try {
				String sql="select * from customer";
				pStmt=con.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();
				
				while(rs.next()) {
					Customer cRef = new Customer();
					cRef.cid=rs.getInt(1);
					cRef.name=rs.getString(2);
					cRef.phone=rs.getString(3);
					cRef.email=rs.getString(4);
					customerList.add(cRef);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			return customerList;
		}
		
		public void UpdateCustomerDataInDB(Customer cRef) {
			try {
				int i=0;
				String sql="update customer set name=?,phone=?,email=? where cid=?";
				pStmt=con.prepareStatement(sql);
				pStmt.setString(1, cRef.name);
				pStmt.setString(2,cRef.phone);
				pStmt.setString(3, cRef.email);
				pStmt.setInt(4, cRef.cid);
				i=pStmt.executeUpdate();
				if(i>0) {
					System.out.println(cRef.name+" Updated");
				}else {
					System.out.println(cRef.name+" not Updated");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void deleteCustomerFromDB(int id) {
			try {
				String sql="delete from customer where cid=?";
				pStmt=con.prepareStatement(sql);
				pStmt.setInt(1, id);
				int i=pStmt.executeUpdate();
				if(i>0) {
					System.out.println("ID : "+id+" Deleted");
				}
				else {
					System.out.println("ID : "+id+" Not Deleted");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		
		public void closeConnection(){
			try {
				con.close();
				System.out.println(">> Connection Closed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
