package com.lovetocode.springdemo.service;

import com.lovetocode.springdemo.entity.Customer;

import java.util.List;

/**
 * Created by macbook on 5/18/17.
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomers(int id);

    public void deleteCustomer(int id);

    public List<Customer> searchCustomer(String nameCustomer);
}
