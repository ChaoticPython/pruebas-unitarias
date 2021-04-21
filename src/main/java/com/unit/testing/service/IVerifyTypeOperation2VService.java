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
   * @param firstValue as number.
   * @param secondValue as number.
   * @param option as the operation.
   * @return a response with the result of the operation.
   */
  ResultResponse verifyTypeOperation(Double firstValue, Double secondValue, String option);

}
