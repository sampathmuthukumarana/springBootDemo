package com.springboot.demo.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.springbootdemo.dto.CustomerDto;
import com.springboot.demo.springbootdemo.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("demo/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	ResponseEntity<List<CustomerDto>> listCustomers() {
		List<CustomerDto> customers = customerService.getCustomers();

		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}

	@PostMapping
	ResponseEntity addCustomers(@RequestBody CustomerDto customerDto) {
		customerService.addCustomers(customerDto);
		return new ResponseEntity("Successfully Inserted", HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity update(@RequestBody CustomerDto customerDto, @PathVariable Integer id) {
		customerService.updateCustomers(customerDto, id);
		return new ResponseEntity("Successfully Updated", HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		customerService.deleteCustomers(id);
		return new ResponseEntity("Successfully Deleted", HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	ResponseEntity<List<CustomerDto>> getSelectedCustomer(@PathVariable Integer id) {
		List<CustomerDto> customers = customerService.getSelectedCustomer(id);

		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}
}
