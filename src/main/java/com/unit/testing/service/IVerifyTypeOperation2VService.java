package com.unit.testing.service;

import com.unit.testing.model.ResultResponse;

/**
 * This is the interface for our Service that receives two values as parameter and the option.
 * 
 * @author JulioPachecoSanginez
 *
 */
public interface IVerifyTypeOperation2VService {

  /**
   * We're going to use this interface method in our service that needs the values
   * and the option wanted.
   * 
   * @param val1 as number.
   * @param val2 as number.
   * @param option as the operation.
   * @return a response with the result of the operation.
   */
  ResultResponse verifyTypeOperation(Double val1, Double val2, String option);

}
