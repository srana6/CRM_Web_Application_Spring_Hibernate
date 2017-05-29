package com.lovetocode.springdemo.dao;

import com.lovetocode.springdemo.entity.Customer;

import java.util.List;

/**
 * Created by macbook on 5/18/17.
 */
public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomers(int id);

    public void deleteCustomer(int id);

    public List<Customer> searchCustomer(String nameCustomer);
}
