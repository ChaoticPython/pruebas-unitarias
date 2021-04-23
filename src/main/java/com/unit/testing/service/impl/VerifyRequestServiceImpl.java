package com.unit.testing.service.impl;

import com.unit.testing.dao.OperationOneValueDao;
import com.unit.testing.dao.OperationsTwoValuesDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is our Service class. In here we redirect to the best option of our received request.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Service
public class VerifyRequestServiceImpl implements IVerifyRequestService {

  /**
   * An instance of a DAO that needs the option and one value (number) as parameter.
   */
  @Autowired
  private OperationOneValueDao operationsOneValueDao;

  /**
   * An instance of a DAO that needs the option and two values (number) as parameters.
   */
  @Autowired
  private OperationsTwoValuesDao operationsTwoValuesDao;

  /**
   * The method receive the request and, based on that, invoke another function to review the
   * request.
   * 
   * @param request as request.
   * @return a response with the result of the operation requested.
   */
  public ResultResponse retrieveResultResponse(OperationRequest request) {
    // Aquí voy a recibir mi resultado
    ResultResponse response = new ResultResponse();
    response.setResultado(verifyRequest(request));
    return response;
  }

  /**
   * The method receive the request and verify it. If the request is null throw an exception, in
   * other case invoke another function to check the values.
   * 
   * @param request as request.
   * @return the possible value of the operation.
   */
  @Override
  public Double verifyRequest(OperationRequest request) {
    if (request.getFirstValue() == null && request.getSecondValue() == null
        || request.getOption() == null) {
      // Tiramos un error por request invalido
      throw new BadRequestException(
          "The request is empty or maybe it doesn't have all the parameter need it");
    } else {
      // Invocamos otro metodo que verifica los valores
      return verifyTwoPossibleValues(request);
    }
  }

  /**
   * The method receive the request and verify the values. If the request has the two values we
   * invoke the DAO for two values, in other case invoke another function to verify at least one
   * value.
   * 
   * @param request as request.
   * @return the value of the operation.
   */
  @Override
  public Double verifyTwoPossibleValues(OperationRequest request) {
    if (request.getFirstValue() != null && request.getSecondValue() != null) {
      // Retornamos el valor de la operación en caso de obtener 2 valores
      return operationsTwoValuesDao.doOperation(request.getOption(), request.getFirstValue(),
          request.getSecondValue());
    } else {
      // Invocamos otro verificador
      return verifyOnePossibleValue(request);
    }
  }

  /**
   * The method receive the request and verify the values. If the request has only one value we
   * invoke the DAO for one value.
   * 
   * @param request as request.
   * @return the value of the operation.
   */
  @Override
  public Double verifyOnePossibleValue(OperationRequest request) {
    if (request.getFirstValue() != null) {
      // Retornamos el resultado de la operación con el primer valor
      return operationsOneValueDao.doOperation(request.getOption(), request.getFirstValue());
    } else {
      // Retornamos el resultado de la operación con el segundo valor
      return operationsOneValueDao.doOperation(request.getOption(), request.getSecondValue());
    }
  }

}
