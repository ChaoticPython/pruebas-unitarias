package com.unit.testing.controller;

import static org.junit.Assert.assertNotNull;

import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyRequestService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

/**
 * This is the unit test for the OperationsController class.
 * 
 * @author JulioPachecoSanginez
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationsControllerTest {

  /**
   * An instance of our service request.
   */
  @Mock
  private IVerifyRequestService verifyRequest;

  /**
   * An instance of our operations controller.
   */
  @InjectMocks
  private OperationsController operationController;

  /**
   * Given a request. 
   * When the request is valid. 
   * Then return the response with the result and the HTTP status.
   */
  @Test
  public void testRetrieveResult() {
    ResultResponse previewResponse = new ResultResponse();

    Mockito.when(verifyRequest.retrieveResultResponse(Mockito.any())).thenReturn(previewResponse);

    ResponseEntity<ResultResponse> response = operationController.retrieveResult(Mockito.any());

    assertNotNull(response);
  }

}
