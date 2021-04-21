package com.unit.testing.service.impl;

import com.unit.testing.dao.OperationsDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyTypeOperation1VService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is our service class that only needs one value to do an operation.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Service
public class VerifyTypeOperation1VServiceImpl implements IVerifyTypeOperation1VService {

  /**
   * An instance of DAO that contains the operations to-do.
   */
  @Autowired
  private OperationsDao operationsDao;

  /**
   * This method receive a value (number) and the option, then calls the operation of the option
   * provided.
   * 
   * @param value as a number.
   * @param option as the operation.
   * @return a response with the result of the operation received.
   */
  @Override
  public ResultResponse verifyTypeOperation(Double value, String option) {
    ResultResponse response = new ResultResponse();
    // Invocamos la operación deseada en el DAO
    if (option.equals("sqrt")) {
      response.setResultado(operationsDao.raizCuadrada(value));
    } else if (option.equals("cbrt")) {
      response.setResultado(operationsDao.raizCubica(value));
    } else if (option.equals("exp")) {
      response.setResultado(operationsDao.exponente(value));
    } else if (option.equals("abs")) {
      response.setResultado(operationsDao.valorAbsoluto(value));
    } else {
      throw new BadRequestException("Imposible realizar la operación");
    }
    return response;
  }

}
