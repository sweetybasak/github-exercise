package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.ifaces.CrudRepository;
import com.training.model.Customer;

public class CustomerRepositoryImpl implements CrudRepository<Customer> {

	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	public CustomerRepositoryImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Customer t) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(?,?,?)";
		pst = con.prepareStatement(sql);
		pst.setInt(1, t.getId());
		pst.setString(2, t.getCustomerName());
		pst.setString(3, t.getEmail());

		int rowAdded = pst.executeUpdate();

		return rowAdded;
	}

	@Override
	public List<Customer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> custList = new ArrayList<>();
		String sql = "select * from customer";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String customerName = rs.getString("customerName");
			String email = rs.getString("email");
			custList.add(new Customer(id, customerName, email));
		}

		return custList;
	}

	@Override
	public Customer findById(int key) throws SQLException {
		// TODO Auto-generated method stub
		Customer cust = null;
		String sql = "select * from customer where id=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, key);
		rs = pst.executeQuery();
		if (rs.next()) {
			String customerName = rs.getString("customerName");
			String email = rs.getString("email");
			int id = rs.getInt("id");
			cust = new Customer(id, customerName, email);

		}
		return cust;

	}

	@Override
	public int remove(int key) throws SQLException {
		// TODO Auto-generated method stub
		int rowdeleted = 0;

		String sql = "delete from customer where id=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1, key);
		rowdeleted = pst.executeUpdate();

		return rowdeleted;
	}

}