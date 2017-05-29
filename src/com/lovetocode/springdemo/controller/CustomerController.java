package com.lovetocode.springdemo.controller;

import com.lovetocode.springdemo.dao.CustomerDAO;
import com.lovetocode.springdemo.entity.Customer;
import com.lovetocode.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by macbook on 5/16/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject customerDAO in this controller
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        //get customers from the DAO
        List<Customer> theCustomer = customerService.getCustomers();

        //add customers to the model
        theModel.addAttribute("customersList",theCustomer);

        return "list-customers";
    }

    @GetMapping("/showformforadd")
    public String showFormForAdd(Model theModel){

        Customer customer1 = new Customer();

        theModel.addAttribute("addNewCustomer",customer1);
        return "customer-add-form";
    }

    /*
    Take the data from the customer Add form
     */
    @PostMapping("/savecustomer")
    public String saveCustomerInfo(@ModelAttribute("addNewCustomer") Customer customer){

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("/showformupdate")
    public String showFormUpdate(@RequestParam("customerID") int id, Model theModel){
        Customer customer = customerService.getCustomers(id);

        theModel.addAttribute("addNewCustomer", customer);

        return "customer-add-form";
    }

    @RequestMapping("/deletedata")
    public String deleteData(@RequestParam("customerID") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @RequestMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel){
        List<Customer> customers = customerService.searchCustomer(theSearchName);
        theModel.addAttribute("customersList",customers);
        return "list-customers";
    }

}
