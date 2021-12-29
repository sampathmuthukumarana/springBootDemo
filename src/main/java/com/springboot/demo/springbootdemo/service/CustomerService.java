package com.springboot.demo.springbootdemo.service;

import java.util.List;

import com.springboot.demo.springbootdemo.dto.CustomerDto;

public interface CustomerService {
	List<CustomerDto> getCustomers();
	int addCustomers(CustomerDto customerDto);
	void updateCustomers(CustomerDto customerDto, int id);
	void deleteCustomers(int id);
	List<CustomerDto> getSelectedCustomer(int id);
}
