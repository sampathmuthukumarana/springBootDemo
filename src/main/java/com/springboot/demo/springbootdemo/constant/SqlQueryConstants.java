package com.springboot.demo.springbootdemo.constant;

public class SqlQueryConstants {
	
	private SqlQueryConstants(){
		
	}
	
	public static final String GET_CUSTOMERS_QUERY = "SELECT id, first_name, last_name, email FROM customer";

	public static final String INSERT_CUSTOMERS_QUERY = "INSERT INTO customer VALUES";

    public static final String UPDATE_CUSTOMERS_QUERY = "UPDATE customer SET ";
    
    public static final String DELETE_CUSTOMERS_QUERY = "DELETE FROM customer WHERE id=";
}
