package com.unit.testing.service;

import com.unit.testing.model.ResultResponse;

/**
 * This is the interface for our Service that receives only one value as parameter and the option.
 * 
 * @author JulioPachecoSanginez
 *
 */
public interface IVerifyTypeOperation1VService {

  /**
   * We're going to use this interface method in our service that needs only one parameter (number)
   * and the option wanted.
   * 
   * @param val as number.
   * @param option as the operation.
   * @return a response with the result of the operation.
   */
  ResultResponse verifyTypeOperation(Double val, String option);

}
