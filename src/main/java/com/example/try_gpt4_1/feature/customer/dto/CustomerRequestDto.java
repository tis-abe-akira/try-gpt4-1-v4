package com.example.try_gpt4_1.feature.customer.dto;

import jakarta.validation.constraints.NotBlank;

public class CustomerRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String contact;
    @NotBlank
    private String industry;

    // getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
