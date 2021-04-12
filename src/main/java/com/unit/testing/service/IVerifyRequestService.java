package com.unit.testing.service;

import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;

public interface IVerifyRequestService {

  ResultResponse retrieveResultResponse(OperationRequest request);

}
