package com.insurance.insurancemanagement.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.insurance.insurancemanagement.entity.Policy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

  private Long id;
  
  @NotEmpty(message = "Please provide a name")
  private String customerName;
  
  @NotEmpty(message = "Please provide a surname")
  private String customerSurname;
  
  @NotEmpty(message = "Please provide a TCKN")
  private String tckn;
  
  @NotNull(message = "Please provide a birth date")
  private Date birthDate;
  
  @NotEmpty(message = "Please provide a Customer Phone")
  private String customerPhone;
  
  @NotEmpty(message = "Please provide an Address")
  private String customerAddress;

}
