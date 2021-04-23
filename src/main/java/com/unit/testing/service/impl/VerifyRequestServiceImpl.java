package com.unit.testing.service.impl;

import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.DoOperationOneValue;
import com.unit.testing.service.DoOperationsTwoValues;
import com.unit.testing.service.IVerifyRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is our principal Service class. In here we redirect to the best option of our received
 * request.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Service
public class VerifyRequestServiceImpl implements IVerifyRequestService {

  /**
   * An instance of other service that needs one value (number) as parameter.
   */
  // @Autowired
  // private IVerifyTypeOperation1VService verifyTypeOperation1VService;
  @Autowired
  private DoOperationOneValue doOperationsOneValue;

  /**
   * An instance of other service that needs two values (numbers) as parameters.
   */
  // @Autowired
  // private IVerifyTypeOperation2VService verifyTypeOperation2VService;
  @Autowired
  private DoOperationsTwoValues doOperationsTwoValues;

  /**
   * The method receive the request and, based on that, redirect to the best option to do the
   * operation.
   * 
   * @param request as request.
   * @return a response with the result of the operation requested.
   */
  @Override
  public ResultResponse retrieveResultResponse(OperationRequest request) {
    // Aquí voy a recibir mi resultado
    ResultResponse response = new ResultResponse();
    // Comprobamos nuestra petición
    if (request.getFirstValue() == null && request.getSecondValue() == null
        || request.getOption() == null) {
      // Tiramos un error por request invalido
      throw new BadRequestException("Hacen falta datos en la petición o está vacía");
    } else {
      // Aquí dirigimos a otro Service según la opción
      if (request.getFirstValue() != null && request.getSecondValue() != null) {
        // Dirigimos a Service que maneja operaciones con 2 valores
        response.setResultado(doOperationsTwoValues.doOperations(request.getOption(),
            request.getFirstValue(), request.getSecondValue()));
      } else if (request.getFirstValue() != null && request.getSecondValue() == null) {
        // Dirigimos a Service que maneja operaciones con 1 valor
        response.setResultado(
            doOperationsOneValue.doOperation(request.getOption(), request.getFirstValue()));
      } else if (request.getFirstValue() == null && request.getSecondValue() != null) {
        // Dirigimos a Service que maneja operaciones con 1 valor
        response.setResultado(
            doOperationsOneValue.doOperation(request.getOption(), request.getSecondValue()));
      }
    }
    return response;
  }

}
