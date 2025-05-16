package com.example.try_gpt4_1.feature.customer.repository;

import com.example.try_gpt4_1.common.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CustomerRepository {
    Customer findById(@Param("id") Long id);

    List<Customer> findAll();

    int insert(Customer customer);

    int update(Customer customer);

    int delete(@Param("id") Long id);

    int count();
}
