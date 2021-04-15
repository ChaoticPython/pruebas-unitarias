package com.unit.testing.model;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a model class for our request.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Getter
@Setter
public class OperationRequest {

  /**
   * Our attributes for get the values and the operation option for process the request.
   */
  private Double val1;

  private String option;

  private Double val2;

}
