package com.orsystem.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.orsystem.db.JDBCTools;
import com.orsystem.modal.Customer;
import com.orsystem.modal.Manager;
import com.orsystem.modal.Product;

public class ProductService {
	public ProductService() {
		super();
		// TODO Auto-generated constructor stub
	}

	//添加商品
	public void addProduct(Object ... args){
		String sql="insert into product values(?,?,?,?)";
		JDBCTools.update(sql, args);
	}
	
	//按商品号删除商品
	public void deleteProductById(String T){
		String sql="delete from product where productno=?";
		JDBCTools.update(sql, T);
	}
	
	//按商品名删除商品
	public void deleteProductByName(String T){
		String sql="delete from product where productName=?";
		JDBCTools.update(sql, T);
	}
	
	//更新商品信息
	public void updateProduct(String sql, Object ... args){
		JDBCTools.update(sql, args);
	}
	//得到全部商品信息
	public List<Product> getAllProduct() throws IOException, ClassNotFoundException, SQLException{
		List<Product> pList=new ArrayList<Product>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from product";
		Statement sta=(Statement) con.createStatement();
		ResultSet rs=sta.executeQuery(sql);
		while(rs.next()){
			Product product=new Product();
	product.setProductNo(rs.getString(1));
	product.setProductName(rs.getString(2));
	product.setProductClass(rs.getString(3));
	product.setProductPrice(rs.getFloat(4));
			pList.add(product);
		}
		return pList;
		
	}
	//得到所有商品的类别名，结果返回类别名的字符串数组
	public String[] getAllClassName() throws SQLException, IOException, ClassNotFoundException{
		List<String> ls = new ArrayList<String>();
		
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select distinct productclass from product";
		Statement sta=(Statement) con.createStatement();
		ResultSet rs=sta.executeQuery(sql);
		while(rs.next()){
			//System.out.println(rs.getString(1));
			ls.add(rs.getString(1));
			
		}
		String[] s=new String[ls.size()+1];
		s[0]="全部";
		for(int j=0;j<ls.size();j++){
			s[j+1]=ls.get(j);
		}
		return s;
	}
	//根据商品类别，得到该类别的所有商品
	public List<Product> getProductByClass(String productclass) throws SQLException, IOException, ClassNotFoundException{
		
		List<Product> pList=new ArrayList<Product>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from product where productclass=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, productclass);
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			Product product=new Product();
	product.setProductNo(rs.getString(1));
	product.setProductName(rs.getString(2));
	product.setProductClass(rs.getString(3));
	product.setProductPrice(rs.getFloat(4));
			pList.add(product);
		}
		return pList;
		
	}
	//根据商品类别和商品价位得到满足条件的商品集合
	public List<Product> getProductByClassAndprice(String productclass,String low_price,String high_price) throws SQLException, IOException, ClassNotFoundException{
		String sql = null;
		PreparedStatement preparedstatement=null;
		ResultSet rs=null;
		List<Product> pList=new ArrayList<Product>();
		
		Connection con=(Connection) JDBCTools.getConnection();
		if(productclass.equals("全部")){
			//假如价位的值为无限制则low_price 和high_price都为no
			if(low_price.equals("no")&&high_price.equals("no")){
				sql="select *from product";
				Statement sta=(Statement) con.createStatement();
				rs=sta.executeQuery(sql);
			}
			//如果条件是<100，则low_price传入的值为no
			else if(low_price.equals("no"))
			{
			sql="select *from product where productprice<?";
		    preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1, high_price);
			rs=(ResultSet) preparedstatement.executeQuery();
			}
			//如果条件是>1000，则high_price传入的值为no
			else if(high_price.equals("no")){
				sql="select *from product where productprice>?";
			    preparedstatement=con.prepareStatement(sql);
				preparedstatement.setString(1, low_price);
				rs=(ResultSet) preparedstatement.executeQuery();
			}
			else{
				sql="select *from product where productprice>=? and productprice<=?";
			    preparedstatement=con.prepareStatement(sql);
				
				preparedstatement.setString(1, low_price);
				preparedstatement.setString(2, high_price);
				rs=(ResultSet) preparedstatement.executeQuery();
			}
		}
		else{
			//假如价位的值为无限制则low_price 和high_price都为no
			if(low_price.equals("no")&&high_price.equals("no")){
				sql="select *from product where productclass=?";
				 preparedstatement=con.prepareStatement(sql);
					preparedstatement.setString(1, productclass);
					rs=(ResultSet) preparedstatement.executeQuery();
			}
			//如果条件是<100，则low_price传入的值为no
			else if(low_price.equals("no"))
			{
			sql="select *from product where productclass=? and productprice<?";
		    preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1, productclass);
			preparedstatement.setString(2, high_price);
			rs=(ResultSet) preparedstatement.executeQuery();
			}
			//如果条件是>1000，则high_price传入的值为no
			else if(high_price.equals("no")){
				sql="select *from product where productclass=? and productprice>?";
			    preparedstatement=con.prepareStatement(sql);
				preparedstatement.setString(1, productclass);
				preparedstatement.setString(2, low_price);
				rs=(ResultSet) preparedstatement.executeQuery();
			}
			else{
				sql="select *from product where productclass=? and productprice>=? and productprice<=?";
			    preparedstatement=con.prepareStatement(sql);
				preparedstatement.setString(1,productclass);
				preparedstatement.setString(2, low_price);
				preparedstatement.setString(3, high_price);
				rs=(ResultSet) preparedstatement.executeQuery();
			}
			
		}
		
	
		while(rs.next()){
			Product product=new Product();
	product.setProductNo(rs.getString(1));
	product.setProductName(rs.getString(2));
	product.setProductClass(rs.getString(3));
	product.setProductPrice(rs.getFloat(4));
			pList.add(product);
		}
		return pList;
		
	} 
	//按商品号查询商品信息
	public Product queryProductById(String id) throws IOException, ClassNotFoundException, SQLException{
		Product product = null;
		Connection con=(Connection) JDBCTools.getConnection();
		String sql="select *from product where productno=?";
		PreparedStatement preparedstatement=con.prepareStatement(sql);
		preparedstatement.setString(1, id);
		
		ResultSet rs=(ResultSet) preparedstatement.executeQuery();
		while(rs.next()){
			product=new Product();
			product.setProductNo(rs.getString(1));
			product.setProductName(rs.getString(2));
			product.setProductClass(rs.getString(3));
			product.setProductPrice(rs.getFloat(4));
		}
		
		return product;
		
	}
	

	
	//按名字查询商品信息
		public Product queryProductByName(String name) throws IOException, ClassNotFoundException, SQLException{
			Product product = null;
			Connection con=(Connection) JDBCTools.getConnection();
			String sql="select *from product where productname=?";
			PreparedStatement preparedstatement=con.prepareStatement(sql);
			preparedstatement.setString(1, name);
			
			ResultSet rs=(ResultSet) preparedstatement.executeQuery();
			while(rs.next()){
				product=new Product();
				product.setProductNo(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductClass(rs.getString(3));
				product.setProductPrice(rs.getFloat(4));
			}
			
			return product;
			
		}
}
