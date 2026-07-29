package com.spring_validation.validation.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AddressOfUsers {
    private String village;
    private String postOffice;
    private String  district;
    private long pinCode;

}
