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
   * Use this interface method in our Service to retrieve a response.
   * 
   * @param request as request.
   * @return a response with the result of the operation.
   */
  ResultResponse retrieveResultResponse(OperationRequest request);

  /**
   * Use this interface method in our Service to verify the request.
   * 
   * @param request as request.
   * @return the possible result of the request.
   */
  Double verifyRequest(OperationRequest request);

  /**
   * Use this interface method in our Service to verify the values in the request.
   * 
   * @param request as request.
   * @return the result of the operation desirable.
   */
  Double verifyTwoPossibleValues(OperationRequest request);

  /**
   * Use this interface method in our Service to verify the values in the request.
   * 
   * @param request as request.
   * @return the result of the operation desirable.
   */
  Double verifyOnePossibleValue(OperationRequest request);

}
