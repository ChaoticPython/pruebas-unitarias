package com.unit.testing.service;

import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;

/**
 * This is the interface for our principal Service.
 * 
 * @author JulioPachecoSanginez
 *
 */
public interface IVerifyRequestService {

  /**
   * We're going to use this interface method in our principal Service.
   * 
   * @param request as request.
   * @return a response with the result of the operation.
   */
  ResultResponse retrieveResultResponse(OperationRequest request);
  
  Double verifyRequest(OperationRequest request);
  
  Double verifyTwoPossibleValues(OperationRequest request);
  
  Double verifyOnePossibleValue(OperationRequest request);

}
