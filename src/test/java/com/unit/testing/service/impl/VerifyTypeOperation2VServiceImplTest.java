package com.unit.testing.service.impl;

import static org.junit.Assert.assertNotNull;

import com.unit.testing.dao.OperationsDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This is the unit test for the Service that has two values (number) and the option.
 * 
 * @author JulioPachecoSanginez
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class VerifyTypeOperation2VServiceImplTest {

  /**
   * An instance of the DAO class for the operations.
   */
  @Mock
  private OperationsDao operationsDAO;

  /**
   * An instance of the service for this test.
   */
  @InjectMocks
  private VerifyTypeOperation2VServiceImpl verifyOperation;

  /**
   * Given the values and the option,
   * When the option is incorrect,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void verifyTypeOperationFirstError() {
    OperationRequest request = new OperationRequest();
    request.setOption("++");
    verifyOperation.verifyTypeOperation(127.32, 332.432, request.getOption());
  }

  /**
   * Given the values and the option,
   * When the option doesn't exist,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void verifyTypeOperationSecondError() {
    OperationRequest request = new OperationRequest();
    request.setOption("a");
    verifyOperation.verifyTypeOperation(127.32, 332.432, request.getOption());
  }

  /**
   * Given the values and the option,
   * When the value of the option is '+',
   * Then invoke the DAO instance to do the 'sum' operation and add the result
   * to the response, then return them.
   */
  @Test
  public void verifyTypeOperationSuma() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(-19.36);
    request.setFirstValue(-7.01);
    request.setOption("+");
    Double result = -26.37;

    ResultResponse previewResponse = generateResponse(result);
    Mockito.when(operationsDAO.suma(request.getFirstValue(), request.getSecondValue()))
        .thenReturn(previewResponse.getResultado());

    ResultResponse response = verifyOperation.verifyTypeOperation(request.getFirstValue(),
        request.getSecondValue(), request.getOption());

    assertNotNull(response);
  }

  /**
   * Given the values and the option,
   * When the value of the option is '-',
   * Then invoke the DAO instance to do the 'subtraction' operation and add the result
   * to the response, then return them.
   */
  @Test
  public void verifyTypeOperationResta() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(-1.96);
    request.setFirstValue(51.263);
    request.setOption("-");
    Double result = -53.223;

    ResultResponse previewResponse = generateResponse(result);
    Mockito.when(operationsDAO.resta(request.getFirstValue(), request.getSecondValue()))
        .thenReturn(previewResponse.getResultado());

    ResultResponse response = verifyOperation.verifyTypeOperation(request.getFirstValue(),
        request.getSecondValue(), request.getOption());

    assertNotNull(response);
  }

  /**
   * Given the values and the option,
   * When the value of the option is '*',
   * Then invoke the DAO instance to do the 'multiplication' operation and add the result
   * to the response, then return them.
   */
  @Test
  public void verifyTypeOperationMultiplicacion() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(-8.302);
    request.setFirstValue(-104.0002);
    request.setOption("*");
    Double result = 863.4096604;

    ResultResponse previewResponse = generateResponse(result);
    Mockito.when(operationsDAO.multiplicacion(request.getFirstValue(), request.getSecondValue()))
        .thenReturn(previewResponse.getResultado());

    ResultResponse response = verifyOperation.verifyTypeOperation(request.getFirstValue(),
        request.getSecondValue(), request.getOption());

    assertNotNull(response);
  }

  /**
   * Given the values and the option,
   * When the value of the option is '/',
   * Then invoke the DAO instance to do the 'division' operation and add the result
   * to the response, then return them.
   */
  @Test
  public void verifyTypeOperationDivision() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(12.0);
    request.setFirstValue(2.0);
    request.setOption("/");
    Double result = 6.0;

    ResultResponse previewResponse = generateResponse(result);
    Mockito.when(operationsDAO.division(request.getFirstValue(), request.getSecondValue()))
        .thenReturn(previewResponse.getResultado());

    ResultResponse response = verifyOperation.verifyTypeOperation(request.getFirstValue(),
        request.getSecondValue(), request.getOption());

    assertNotNull(response);
  }

  /**
   * Given the values and the option,
   * When the value of the option is '^',
   * Then invoke the DAO instance to do the 'power' operation and add the result
   * to the response, then return them.
   */
  @Test
  public void verifyTypeOperationPotencia() {
    OperationRequest request = new OperationRequest();
    request.setFirstValue(1.0);
    request.setFirstValue(5421.3);
    request.setOption("^");
    Double result = 1.0;

    ResultResponse previewResponse = generateResponse(result);
    Mockito.when(operationsDAO.potencia(request.getFirstValue(), request.getSecondValue()))
        .thenReturn(previewResponse.getResultado());

    ResultResponse response = verifyOperation.verifyTypeOperation(request.getFirstValue(),
        request.getSecondValue(), request.getOption());

    assertNotNull(response);
  }

  /**
   * This method generate the preview response for all the methods before.
   * 
   * @param value as number.
   * @return the response generated.
   */
  private ResultResponse generateResponse(Double value) {
    // TODO Auto-generated method stub
    ResultResponse response = new ResultResponse();
    response.setResultado(value);
    return response;
  }

}
