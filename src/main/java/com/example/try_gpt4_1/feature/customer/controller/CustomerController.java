package com.example.try_gpt4_1.feature.customer.controller;

import com.example.try_gpt4_1.feature.customer.dto.CustomerRequestDto;
import com.example.try_gpt4_1.feature.customer.dto.CustomerResponseDto;
import com.example.try_gpt4_1.feature.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerResponseDto getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    public List<CustomerResponseDto> getAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return customerService.findAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto create(@RequestBody @Valid CustomerRequestDto dto) {
        return customerService.create(dto);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto update(@PathVariable Long id, @RequestBody @Valid CustomerRequestDto dto) {
        return customerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
