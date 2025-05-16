package com.example.try_gpt4_1.feature.customer.service;

import com.example.try_gpt4_1.feature.customer.dto.CustomerRequestDto;
import com.example.try_gpt4_1.feature.customer.dto.CustomerResponseDto;
import java.util.List;

public interface CustomerService {
    CustomerResponseDto findById(Long id);

    List<CustomerResponseDto> findAll(int page, int size);

    CustomerResponseDto create(CustomerRequestDto dto);

    CustomerResponseDto update(Long id, CustomerRequestDto dto);

    void delete(Long id);

    int count();
}
