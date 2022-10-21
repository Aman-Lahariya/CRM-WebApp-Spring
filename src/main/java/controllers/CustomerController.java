package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import doa.CustomerDOA;
import entity.Customer;
import service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customerList = customerService.getCustomers();
		model.addAttribute("customersList", customerList);
		return "customer-list";
	}
	
	@GetMapping("/addCustomerForm")
	public String showAddCustomerForm(Model model) {
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		model.addAttribute("customerFormModelAttribute", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customerFormModelAttribute") Customer modelCustomer) {
		customerService.saveCustomer(modelCustomer);	
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") int cId, Model model) {
		Customer customer = customerService.getCustomer(cId);
		model.addAttribute("customerFormModelAttribute", customer);
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int custID) {
		customerService.deleteCustomer(custID);
		return "redirect:/customer/list";
	}
	
	 @GetMapping("/searchCustomer")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
	        // search customers from the service
	        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
	                
	        // add the customers to the model
	        theModel.addAttribute("customersList", theCustomers);
	        return "customer-list";        
	    }
}
