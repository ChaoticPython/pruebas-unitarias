package com.unit.testing.service.impl;

import static org.junit.Assert.assertNotNull;

import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyTypeOperation1VService;
import com.unit.testing.service.IVerifyTypeOperation2VService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This is the unit test for the principal Service.
 * 
 * @author JulioPachecoSanginez
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class VerifyRequestServiceImplTest {

  /**
   * An instance of the service that receive one value (number).
   */
  @Mock
  private IVerifyTypeOperation1VService verifyOperation1Value;

  /**
   * An instance of the service that receive two values (numbers).
   */
  @Mock
  private IVerifyTypeOperation2VService verifyOperation2Value;

  /**
   * An instance of our principal service.
   */
  @InjectMocks
  private VerifyRequestServiceImpl verifyRequest;

  /**
   * Given a request,
   * When the request is empty,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void retrieveResultResponseAllNull() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(null);
    request.setSecondValue(null);
    request.setOption(null);

    verifyRequest.retrieveResultResponse(request);
  }

  /**
   * Given a request,
   * When the request has the two values (numbers) as null,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void retrieveResultResponse2VNull() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(null);
    request.setSecondValue(null);
    request.setOption("any");

    verifyRequest.retrieveResultResponse(request);
  }

  /**
   * Given a request,
   * When the request has the second value (number) and the option null,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void retrieveResultResponseVal2Null() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(98.31);
    request.setSecondValue(null);
    request.setOption(null);

    verifyRequest.retrieveResultResponse(request);
  }

  /**
   * Given a request
   * When the request has the first value (number) and the option null,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void retrieveResultResponseVal1Null() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(null);
    request.setSecondValue(9823.121);
    request.setOption(null);

    verifyRequest.retrieveResultResponse(request);
  }

  /**
   * Given a request,
   * When the request only hast the option null,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void retrieveResultResponseOptionNull() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(1.2192);
    request.setSecondValue(31.21);
    request.setOption(null);

    verifyRequest.retrieveResultResponse(request);
  }

  /**
   * Given a request,
   * When the request has only the second value (number) as null,
   * Then redirect to other service and get the response.
   */
  @Test
  public void retrieveResultResponseWithFirstValue() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(1.2192);
    request.setSecondValue(null);
    request.setOption("option");

    ResultResponse previewResponse = new ResultResponse();
    Mockito.when(verifyOperation1Value.verifyTypeOperation(request.getFirstValue(), request.getOption()))
        .thenReturn(previewResponse);

    ResultResponse response = verifyRequest.retrieveResultResponse(request);

    assertNotNull(response);
  }

  /**
   * Given a request,
   * When the request has only the first value (number) as null,
   * Then redirect to other service and get the response.
   */
  @Test
  public void retrieveResultResponseWithSecondValue() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(null);
    request.setSecondValue(31.21);
    request.setOption("option");

    ResultResponse previewResponse = new ResultResponse();
    Mockito.when(verifyOperation1Value.verifyTypeOperation(request.getSecondValue(), request.getOption()))
        .thenReturn(previewResponse);

    ResultResponse response = verifyRequest.retrieveResultResponse(request);

    assertNotNull(response);
  }

  /**
   * Given a request,
   * When the request has all the values (numbers and option),
   * Then redirect to other service and get the response.
   */
  @Test
  public void retrieveResultResponseWithValues() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(1.2192);
    request.setSecondValue(31.21);
    request.setOption("option");

    ResultResponse previewResponse = new ResultResponse();
    Mockito.when(verifyOperation2Value.verifyTypeOperation(request.getFirstValue(), request.getSecondValue(),
        request.getOption())).thenReturn(previewResponse);

    ResultResponse response = verifyRequest.retrieveResultResponse(request);

    assertNotNull(response);
  }

}
