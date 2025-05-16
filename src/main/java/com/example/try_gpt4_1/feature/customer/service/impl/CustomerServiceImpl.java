package com.example.try_gpt4_1.feature.customer.service.impl;

import com.example.try_gpt4_1.common.entity.Customer;
import com.example.try_gpt4_1.feature.customer.dto.CustomerRequestDto;
import com.example.try_gpt4_1.feature.customer.dto.CustomerResponseDto;
import com.example.try_gpt4_1.feature.customer.repository.CustomerRepository;
import com.example.try_gpt4_1.feature.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto findById(Long id) {
        Customer customer = customerRepository.findById(id);
        if (customer == null)
            throw new IllegalArgumentException("Customer not found");
        return toResponseDto(customer);
    }

    @Override
    public List<CustomerResponseDto> findAll(int page, int size) {
        List<Customer> all = customerRepository.findAll();
        return all.stream()
                .skip((long) page * size)
                .limit(size)
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerResponseDto create(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setContact(dto.getContact());
        customer.setIndustry(dto.getIndustry());
        customerRepository.insert(customer);
        return toResponseDto(customer);
    }

    @Override
    @Transactional
    public CustomerResponseDto update(Long id, CustomerRequestDto dto) {
        Customer customer = customerRepository.findById(id);
        if (customer == null)
            throw new IllegalArgumentException("Customer not found");
        customer.setName(dto.getName());
        customer.setContact(dto.getContact());
        customer.setIndustry(dto.getIndustry());
        customerRepository.update(customer);
        return toResponseDto(customer);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id);
        if (customer == null)
            throw new IllegalArgumentException("Customer not found");
        customerRepository.delete(id);
    }

    @Override
    public int count() {
        return customerRepository.count();
    }

    private CustomerResponseDto toResponseDto(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setContact(customer.getContact());
        dto.setIndustry(customer.getIndustry());
        return dto;
    }
}
