package com.unit.testing.helper;

import org.springframework.stereotype.Component;

/**
 * This is a component that provide the basic operations for a calculator.
 * 
 * @author ChaoticPython
 *
 */
@Component
public class OperationsHelper {

  /**
   * This method does the add operation.
   * 
   * @param firstValue as a double value.
   * @param secondValue as a double value.
   * @return the result of the add operation between the firstValue and the secondValue.
   */
  public Double add(Double firstValue, Double secondValue) {
    return firstValue + secondValue;
  }

  /**
   * This method does the subtraction operation.
   * 
   * @param firstValue as a double value.
   * @param secondValue as a double value.
   * @return the result of the subtraction operation between the firstValue and the secondValue.
   */
  public Double subtraction(Double firstValue, Double secondValue) {
    return firstValue - secondValue;
  }

  /**
   * This method does the multiplication operation.
   * 
   * @param firstValue as a double value.
   * @param secondValue as a double value.
   * @return the result of the multiplication operation between the firstValue and the secondValue.
   */
  public Double multiplication(Double firstValue, Double secondValue) {
    return firstValue * secondValue;
  }

  /**
   * This method does the division operation.
   * 
   * @param firstValue as a double value.
   * @param secondValue as a double value.
   * @return the result of the division operation between the firstValue and the secondValue.
   */
  public Double division(Double firstValue, Double secondValue) {
    return firstValue / secondValue;
  }

}
