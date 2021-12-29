package com.springboot.demo.springbootdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.demo.springbootdemo.constant.SqlQueryConstants;
import com.springboot.demo.springbootdemo.dao.mapper.CustomerMapper;
import com.springboot.demo.springbootdemo.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerDto> getCustomerRecords() {

		return jdbcTemplate.query(SqlQueryConstants.GET_CUSTOMERS_QUERY, new CustomerMapper());
	}

	@Override
	public int addCustomers(CustomerDto customerDto) {
		String values = "('" + customerDto.getFirstName() + "','" + customerDto.getLastName() + "','"
				+ customerDto.getEmail() + "')";
		return jdbcTemplate.update((SqlQueryConstants.INSERT_CUSTOMERS_QUERY + values));

	}

	@Override
	public void updateCustomers(CustomerDto customerDto, int id) {
		String updatedValues = "first_name='" + customerDto.getFirstName() + "',last_name='" + customerDto.getLastName()
				+ "',email='" + customerDto.getEmail() + "'WHERE id='" + id + "'";
		jdbcTemplate.update((SqlQueryConstants.UPDATE_CUSTOMERS_QUERY + updatedValues));

	}

	@Override
	public void deleteCustomers(int id) {
		String deleteId = "'" + id + "'";
		jdbcTemplate.update((SqlQueryConstants.DELETE_CUSTOMERS_QUERY + deleteId));

	}

	@Override
	public List<CustomerDto> getSelectedCustomer(int id) {
		return jdbcTemplate.query(SqlQueryConstants.GET_CUSTOMERS_QUERY + " WHERE id='"+id+"'", new CustomerMapper());
	}

}
