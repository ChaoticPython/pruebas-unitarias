package com.unit.testing.controller;

import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the Controller of the Microservice.
 * 
 * @author JulioPachecoSanginez
 *
 */
@RestController
@RequestMapping("${micro-operations.context.path}")
public class OperationsController {

  /**
   * An instance of the principal Service.
   */
  @Autowired
  private IVerifyRequestService verifyRequestService;

  /**
   * The method receive the request with the parameters needed for the response
   * 
   * @param request
   * @return a response with the result of the operation requested
   */
  @PostMapping("${micro-operations.paths.operations}")
  public ResponseEntity<ResultResponse> retrieveResult(@RequestBody OperationRequest request) {
    ResultResponse response = verifyRequestService.retrieveResultResponse(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
