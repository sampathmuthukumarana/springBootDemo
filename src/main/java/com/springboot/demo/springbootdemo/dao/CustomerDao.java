package com.springboot.demo.springbootdemo.dao;

import java.util.List;

import com.springboot.demo.springbootdemo.dto.CustomerDto;

public interface CustomerDao {
	
	List<CustomerDto> getCustomerRecords();
	int addCustomers(CustomerDto customerDto);
	void updateCustomers(CustomerDto customerDto, int id);
	void deleteCustomers(int id);
	List<CustomerDto> getSelectedCustomer(int id);

}
