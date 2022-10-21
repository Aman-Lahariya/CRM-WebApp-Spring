package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import doa.CustomerDOA;
import entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDOA customerDOA;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDOA.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDOA.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDOA.getCustomer(customerId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDOA.deleteCustomer(customerId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDOA.searchCustomers(theSearchName);
	}

}
