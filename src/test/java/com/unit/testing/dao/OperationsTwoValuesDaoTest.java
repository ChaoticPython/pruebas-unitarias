package com.unit.testing.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.unit.testing.exception.BadRequestException;
import com.unit.testing.helper.OperationsHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This is the unit test for the DAO that receives two values for the operation.
 * 
 * @author ChaoticPython
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationsTwoValuesDaoTest {

  /**
   * An instances of our helper class.
   */
  @Mock
  private OperationsHelper operationsHelper;
  
  /**
   * An instance of our DAO class.
   */
  @InjectMocks
  private OperationsTwoValuesDao operationsTwoValuesDao;
  
  /**
   * Given an operation and two values,
   * When the operation doesn't exists,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void testDoOperationsError() {
    String operation = "anything";
    Double firstValue = 12.901;
    Double secondValue = 3.78;
    
    operationsTwoValuesDao.init();
    operationsTwoValuesDao.doOperation(operation, firstValue, secondValue);
  }
  
  /**
   * Given an operation and two values,
   * When the operation exists,
   * Then does the operation and return the result.
   */
  @Test
  public void testDoOperation() {
    String operation = "^";
    Double firstValue = 2.0;
    Double secondValue = 2.0;
    Double previewResponse = 4.0;
    
    operationsTwoValuesDao.init();
    Double response = operationsTwoValuesDao.doOperation(operation, firstValue, secondValue);
    
    assertEquals(previewResponse, response);
  }
  
}
