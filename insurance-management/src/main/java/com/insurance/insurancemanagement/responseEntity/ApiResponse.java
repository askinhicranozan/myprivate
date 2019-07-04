package com.insurance.insurancemanagement.responseEntity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ApiResponse {

  private ApiResponseStatus status;

  private Object data;

  private List<ApiError> errors;

  private List<ApiWarning> warnings;

  public ApiResponse() {
    super();
  }

  public ApiResponse(ApiResponseStatus status, Object data) {
    super();
    this.status = status;
    this.data = data;
  }

  public ApiResponse(ApiResponseStatus status, Object data,
      List<ApiError> errors) {
    super();
    this.status = status;
    this.data = data;
    this.errors = errors;
  }

}
