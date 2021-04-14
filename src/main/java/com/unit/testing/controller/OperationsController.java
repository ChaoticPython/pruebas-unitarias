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

@RestController
@RequestMapping("${micro-operations.context.path}")
public class OperationsController {

  @Autowired
  private IVerifyRequestService verifyRequestService;

  @PostMapping("${micro-operations.paths.operations}")
  public ResponseEntity<ResultResponse> retrieveResult(@RequestBody OperationRequest request) {
    ResultResponse response = verifyRequestService.retrieveResultResponse(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
