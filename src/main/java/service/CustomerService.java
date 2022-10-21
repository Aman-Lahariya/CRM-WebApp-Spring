package service;

import java.util.List;

import entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomer(int cId);

	public void deleteCustomer(int custID);

	public List<Customer> searchCustomers(String theSearchName);

}
