package com.unit.testing.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.unit.testing.exception.BadRequestException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This is the unit test for the DAO that receives one value for the operation.
 * 
 * @author ChaoticPython
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationOneValueDaoTest {

  /**
   * An instance of our DAO class.
   */
  @InjectMocks
  private OperationOneValueDao operationOneValueDao;

  /**
   * Given an operation and a value,
   * When the operation doesn't exists,
   * Then throw a BadRequestException.
   */
  @Test(expected = BadRequestException.class)
  public void testDoOperationError() {
    String operation = "anything";
    Double value = 19.2;

    operationOneValueDao.init();
    operationOneValueDao.doOperation(operation, value);
  }

  /**
   * Given an operation and a value,
   * When the operation exists,
   * Then does the operation and return the result.
   */
  @Test
  public void testDoOperation() {
    String operation = "sqrt";
    Double value = 4.0;
    Double previewResponse = 2.0;

    operationOneValueDao.init();
    Double response = operationOneValueDao.doOperation(operation, value);

    assertEquals(previewResponse, response);
  }

}
