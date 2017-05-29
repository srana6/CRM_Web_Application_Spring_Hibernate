package com.lovetocode.springdemo.dao;

import com.lovetocode.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

/**
 * Created by macbook on 5/18/17.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //1) get current hibernate session
        Session session = sessionFactory.getCurrentSession();
        //2) create a query

       org.hibernate.query.Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);

        //3) get the list of customers from the query

        List<Customer> customers = theQuery.getResultList();

        //4) return the list of retrived customers
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomers(int theId) {
        Session currentSessuion = sessionFactory.getCurrentSession();
        Customer theCustomer=currentSessuion.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSessuion = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<Customer> theQuery = currentSessuion.createQuery("delete from Customer where id=:customerID");
        theQuery.setParameter("customerID",theId);
        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(String nameCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<Customer> theQuery = null;
        if(nameCustomer != null && nameCustomer.trim().length()>0){
            theQuery = currentSession.createQuery("from Customer where lower(firstName) like:theName or lower(lastName) like:theName", Customer.class);
            theQuery.setParameter("theName", "%"+ nameCustomer.toLowerCase()+"%");
        }else{
            theQuery = currentSession.createQuery("from Customer",Customer.class);
        }

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }
}
