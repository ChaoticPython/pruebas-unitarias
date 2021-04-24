package com.unit.testing.dao;

import com.unit.testing.OperationsHelper;
import com.unit.testing.exception.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import javax.annotation.PostConstruct;

/**
 * This class has the operations that we are going to make with the two values in the request.
 * 
 * @author ChaoticPython
 *
 */
@Component
public class OperationsTwoValuesDao {

  /**
   * This instance must contain the necessary operations (for two values).
   * 
   */
  private Map<String, BiFunction<Double, Double, Double>> operations;
  
  @Autowired
  private OperationsHelper operationsHelper;

  /**
   * This method initialize a Map and define the operations.
   * 
   */
  @PostConstruct
  public void init() {
    operations = new HashMap<>();
    operations.put("+", operationsHelper::add);
    operations.put("-", operationsHelper::less);
    operations.put("*", operationsHelper::multiplication);
    operations.put("/", operationsHelper::division);
    operations.put("^", Math::pow);
  }
  
  /**
   * This method verify if the operation sent in the request exists. If the operation doesn't
   * exists, then throw an exception.
   * 
   * @param operation as a String with the operation.
   * @param firstValue as the firstValue to evaluate.
   * @param secondValue as the secondValue to evaluate.
   * @return the result (Double) of the operation or an exception if has a problem.
   */
  public Double doOperation(String option, Double firstValue, Double secondValue) {
    if(operations.containsKey(option)) {
      return operations.get(option).apply(firstValue, secondValue);
    } else {
      throw new BadRequestException("The operation doesn't exist, check it.");
    }
  }
  
}
