package ru.gb.sklyarov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sklyarov.dao.CustomerDao;

@Service
public class CustomerService {
    private CustomerDao customerRepository;

    @Autowired
    public CustomerService(CustomerDao customerRepository) {
        this.customerRepository = customerRepository;
    }
}
