package com.springboot.demo.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.springbootdemo.dao.CustomerDao;
import com.springboot.demo.springbootdemo.dto.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerDto> getCustomers() {
		return customerDao.getCustomerRecords();
	}

	@Override
	public int addCustomers(CustomerDto customerDto) {
		return customerDao.addCustomers(customerDto);

	}

	@Override
	public void updateCustomers(CustomerDto customerDto, int id) {
		customerDao.updateCustomers(customerDto, id);

	}

	@Override
	public void deleteCustomers(int id) {
		customerDao.deleteCustomers(id);

	}

	@Override
	public List<CustomerDto> getSelectedCustomer(int id) {
		return customerDao.getSelectedCustomer(id);

	}

}
