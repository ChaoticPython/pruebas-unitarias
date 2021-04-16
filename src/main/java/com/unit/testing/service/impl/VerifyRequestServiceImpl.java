package com.unit.testing.service.impl;

import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyRequestService;
import com.unit.testing.service.IVerifyTypeOperation1VService;
import com.unit.testing.service.IVerifyTypeOperation2VService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is our principal Service class.
 * In here we redirect to the best option of our received request.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Service
public class VerifyRequestServiceImpl implements IVerifyRequestService {

  /**
   * An instance of other service that needs one value (number) as parameter.
   */
  @Autowired
  private IVerifyTypeOperation1VService verifyTypeOperation1VService;

  /**
   * An instance of other service that needs two values (numbers) as parameters.
   */
  @Autowired
  private IVerifyTypeOperation2VService verifyTypeOperation2VService;

  /**
   * The method receive the request and, based on that, redirect to the best 
   * option to do the operation.
   * 
   * @param request as request.
   * @return a response with the result of the operation requested.
   */
  @Override
  public ResultResponse retrieveResultResponse(OperationRequest request) {
    // Aquí voy a recibir mi resultado
    ResultResponse response = new ResultResponse();
    // Comprobamos nuestra petición
    if (request.getVal1() == null && request.getVal2() == null || request.getOption() == null) {
      // Tiramos un error por request invalido
      throw new BadRequestException("Hacen falta datos en la petición o está vacía");
    } else {
      // Aquí dirigimos a otro Service según la opción
      if (request.getVal1() != null && request.getVal2() != null) {
        // Dirigimos a Service que maneja operaciones con 2 valores
        response = verifyTypeOperation2VService.verifyTypeOperation(request.getVal1(),
            request.getVal2(), request.getOption());
      } else if (request.getVal1() != null && request.getVal2() == null) {
        // Dirigimos a Service que maneja operaciones con 1 valor
        response = verifyTypeOperation1VService.verifyTypeOperation(request.getVal1(),
            request.getOption());
      } else if (request.getVal1() == null && request.getVal2() != null) {
        // Dirigimos a Service que maneja operaciones con 1 valor
        response = verifyTypeOperation1VService.verifyTypeOperation(request.getVal2(),
            request.getOption());
      }
    }
    return response;
  }

}
