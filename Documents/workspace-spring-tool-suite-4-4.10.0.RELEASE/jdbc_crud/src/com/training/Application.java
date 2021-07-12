package com.training;

import java.sql.*;
import java.util.*;

import com.training.daos.CustomerRepositoryImpl;
import com.training.model.Customer;

import com.training.utils.DbConnection;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getConnection();
		CustomerRepositoryImpl dao = new CustomerRepositoryImpl(con);
		int ch = 4;
		try {
			if (ch == 1) {
				dao.add(new Customer(5, "Ramh", "pram@abc.com"));
				dao.add(new Customer(6, "Suresha", "suresha@abc.com"));

			}
			if (ch == 2) {
				List<Customer> list = dao.findAll();
				for (Customer eachCustomer : list) {
					System.out.println(eachCustomer);
				}

			}
			if (ch == 3) {
				Customer cust = dao.findById(3);

				System.out.println(cust);

			}
			if (ch == 4) {
				if (dao.remove(3) == 1) {
					System.out.println("Customer removed");
				} else {
					System.out.println("Customerremoved from database");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
