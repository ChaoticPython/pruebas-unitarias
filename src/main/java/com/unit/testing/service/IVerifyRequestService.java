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

}
