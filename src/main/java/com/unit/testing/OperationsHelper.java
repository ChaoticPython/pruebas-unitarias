package com.unit.testing;

import org.springframework.stereotype.Component;

@Component
public class OperationsHelper {

  public Double add(Double firstValue, Double secondValue) {
    return firstValue + secondValue;
  }
  
  public Double less(Double firstValue, Double secondValue) {
    return firstValue - secondValue;
  }
  
  public Double multiplication(Double firstValue, Double secondValue) {
    return firstValue * secondValue;
  }
  
  public Double division(Double firstValue, Double secondValue) {
    return firstValue / secondValue;
  }
  
}
