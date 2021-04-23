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
  private OperationOneValueDao doOperationsOneValue;

  /**
   * An instance of a DAO that needs the option and two values (number) as parameters.
   */
  @Autowired
  private OperationsTwoValuesDao doOperationsTwoValues;

  /**
   * The method receive the request and, based on that, redirect to the best option to do the
   * operation.
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

  @Override
  public Double verifyRequest(OperationRequest request) {
    if (request.getFirstValue() == null && request.getSecondValue() == null
        || request.getOption() == null) {
      // Tiramos un error por request invalido
      throw new BadRequestException("Hacen falta datos en la petición o está vacía");
    } else {
      // Invocamos otro metodo que verifica los valores
      return verifyTwoPossibleValues(request);
    }
  }

  @Override
  public Double verifyTwoPossibleValues(OperationRequest request) {
    if (request.getFirstValue() != null && request.getSecondValue() != null) {
      // Retornamos el valor de la operación en caso de obtener 2 valores
      return doOperationsTwoValues.doOperation(request.getOption(), request.getFirstValue(),
          request.getSecondValue());
    } else {
      // Invocamos otro verificador
      return verifyOnePossibleValue(request);
    }
  }

  @Override
  public Double verifyOnePossibleValue(OperationRequest request) {
    if (request.getFirstValue() != null) {
      // Retornamos el resultado de la operación con el primer valor
      return doOperationsOneValue.doOperation(request.getOption(), request.getFirstValue());
    } else {
      // Retornamos el resultado de la operación con el segundo valor
      return doOperationsOneValue.doOperation(request.getOption(), request.getSecondValue());
    }
  }

}
