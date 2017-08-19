package com.tutorials;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorials.data.Customer;
import com.tutorials.data.CustomerRepository;


import org.slf4j.LoggerFactory;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository repository = null;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	
    @GetMapping("/customer")
    public String customerForm( @RequestParam("name") String name, Model model) {
    		Customer customer = repository.findByLastName(name).get(0);
    		model.addAttribute("customer", customer);
        return "results";
    }
    
    @GetMapping("/customers")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }
    

    @PostMapping("/customers")
    public String greetingSubmit(@ModelAttribute Customer customer) {
    repository.save(customer);
    log.info("Saved customer:"+customer);
    	return "results";
    }
    
    
    @Bean
	public CommandLineRunner demo(
			final CustomerRepository repository) {
    	
    			//this.repository = repository;
			
			return (args) -> {
				// save a couple of customers
				repository.save(new Customer("Jack", "Bauer"));
				repository.save(new Customer("Chloe", "O'Brian"));
				repository.save(new Customer("Kim", "Bauer"));
				repository.save(new Customer("David", "Palmer"));
				repository.save(new Customer("Michelle", "Dessler"));

				// fetch all customers
				log.info("Customers found with findAll():");
				log.info("-------------------------------");
				for (Customer customer : repository.findAll()) {
					log.info(customer.toString());
				}
				log.info("");

				// fetch an individual customer by ID
				Customer customer = repository.findOne(1L);
				log.info("Customer found with findOne(1L):");
				log.info("--------------------------------");
				log.info(customer.toString());
				log.info("");

				// fetch customers by last name
				log.info("Customer found with findByLastName('Bauer'):");
				log.info("--------------------------------------------");
				for (Customer bauer : repository.findByLastName("Bauer")) {
					log.info(bauer.toString());
				}
				log.info("");
			};
		}



    
    

    
    

}
