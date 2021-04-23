package com.unit.testing.service.impl;

import static org.junit.Assert.assertNotNull;

import com.unit.testing.dao.OperationOneValueDao;
import com.unit.testing.dao.OperationsTwoValuesDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
   * An instance of the DAO that receive one value (number).
   */
  @Mock
  private OperationOneValueDao operationOneValueDao;

  /**
   * An instance of the DAO that receive two values (numbers).
   */
  @Mock
  private OperationsTwoValuesDao operationsTwoValuesDao;

  /**
   * An instance of our service.
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
   * Given a request,
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
   * When the request only has the option null, 
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
   * When the request has all the values (numbers and option), 
   * Then do the operation desired and return the response.
   */
  @Test
  public void retrieveResultResponseWithValues() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(1.2192);
    request.setSecondValue(31.21);
    request.setOption("option");

    ResultResponse response = verifyRequest.retrieveResultResponse(request);

    assertNotNull(response);
  }

  /**
   * Given a request, 
   * When the request has only the first value (number) as null, 
   * Then do the operation desired and return the response.
   */
  @Test
  public void retrieveResultResponseWithSecondValue() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(null);
    request.setSecondValue(31.21);
    request.setOption("option");

    ResultResponse response = verifyRequest.retrieveResultResponse(request);

    assertNotNull(response);
  }

  /**
   * Given a request, 
   * When the request has only the second value (number) as null, 
   * Then do the operation desired and return the response.
   */
  @Test
  public void retrieveResultResponseWithFirstValue() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(1.2192);
    request.setSecondValue(null);
    request.setOption("option");

    ResultResponse response = verifyRequest.retrieveResultResponse(request);

    assertNotNull(response);
  }

}
