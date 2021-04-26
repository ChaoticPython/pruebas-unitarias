package com.unit.testing.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This is the unit test for the 'OperationsHelper' class.
 * 
 * @author ChaoticPython
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationsHelperTest {

  /**
   * An instance of our helper class.
   */
  @InjectMocks
  private OperationsHelper operationsHelper;

  /**
   * Given two double values, 
   * When invoke the 'add' operation, 
   * Then the operation is performed, we get the result of the operation and return it.
   */
  @Test
  public void testAdd() {
    Double previewResponse = 19.3;
    Double response = operationsHelper.add(6.12, 13.18);
    assertEquals(previewResponse, response);
  }

  /**
   * Given two double values, 
   * When invoke the 'subtraction' operation, 
   * Then the operation is performed, we get the result of the operation and return it.
   */
  @Test
  public void testSubtraction() {
    Double previewResponse = -2.299999999999997;
    Double response = operationsHelper.subtraction(19.1, 21.4);
    assertEquals(previewResponse, response);
  }

  /**
   * Given two double values, 
   * When invoke the 'multiplication' operation, 
   * Then the operation is performed, we get the result of the operation and return it.
   */
  @Test
  public void testMultiplication() {
    Double previewResponse = 168.84553;
    Double response = operationsHelper.multiplication(13.93, 12.121);
    assertEquals(previewResponse, response);
  }

  /**
   * Given two double values, 
   * When invoke the 'division' operation, 
   * Then the operation is performed, we get the result of the operation and return it.
   */
  @Test
  public void testDivision() {
    Double previewResponse = 2.522938094313992;
    Double response = operationsHelper.division(26.0014, 10.306);
    assertEquals(previewResponse, response);
  }

}
