package com.unit.testing.service.impl;

import com.unit.testing.dao.OperationsDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyTypeOperation2VService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is our service class that needs two value to do an operation.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Service
public class VerifyTypeOperation2VServiceImpl implements IVerifyTypeOperation2VService {

  /**
   * An instance of DAO that contains the operations to-do.
   */
  @Autowired
  private OperationsDao operationsDao;

  /**
   * This method receive two values (numbers) and the option, then calls the operation of the option
   * provided.
   * 
   * @param val1 as a number.
   * @param val2 as a number.
   * @param option as the operation.
   * @return a response with the result of the operation received.
   */
  @Override
  public ResultResponse verifyTypeOperation(Double val1, Double val2, String option) {
    ResultResponse response = new ResultResponse();
    // Verificamos el tipo de operación que se solicita
    if (option.length() > 1) {
      // Lanzamos una excepción, solo debe ser un caracter para éstas operaciones
      throw new BadRequestException("No se puede realizar dicha operaciòn");
    } else {
      if (option.equals("+")) {
        // Invocamos la operación deseada en el DAO
        response.setResultado(operationsDao.suma(val1, val2));
      } else if (option.equals("-")) {
        response.setResultado(operationsDao.resta(val1, val2));
      } else if (option.equals("*")) {
        response.setResultado(operationsDao.multiplicacion(val1, val2));
      } else if (option.equals("/")) {
        response.setResultado(operationsDao.division(val1, val2));
      } else if (option.equals("^")) {
        response.setResultado(operationsDao.potencia(val1, val2));
      } else {
        throw new BadRequestException("No existe dicha operacion");
      }
    }
    return response;
  }

}
