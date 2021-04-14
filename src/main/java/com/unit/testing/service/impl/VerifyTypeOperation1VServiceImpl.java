package com.unit.testing.service.impl;

import com.unit.testing.dao.OperationsDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyTypeOperation1VService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyTypeOperation1VServiceImpl implements IVerifyTypeOperation1VService {

  @Autowired
  private OperationsDao operationsDao;

  @Override
  public ResultResponse verifyTypeOperation(Double val, String option) {
    ResultResponse response = new ResultResponse();
    // Invocamos la operación deseada en el DAO
    if (option.equals("sqrt")) {
      response.setResultado(operationsDao.raizCuadrada(val));
    } else if (option.equals("cbrt")) {
      response.setResultado(operationsDao.raizCubica(val));
    } else if (option.equals("exp")) {
      response.setResultado(operationsDao.exponente(val));
    } else if (option.equals("abs")) {
      response.setResultado(operationsDao.valorAbsoluto(val));
    } else {
      throw new BadRequestException("Imposible realizar la operación");
    }
    return response;
  }

}
