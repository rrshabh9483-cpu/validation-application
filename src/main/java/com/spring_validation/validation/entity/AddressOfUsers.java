package com.spring_validation.validation.entity;

import lombok.Data;

@Data
public class AddressOfUsers {
    private String village;
    private String postOffice;
    private String  district;
    private long pinCode;

}
