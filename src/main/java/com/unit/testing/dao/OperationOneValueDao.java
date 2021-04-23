package com.unit.testing.dao;

import com.unit.testing.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.PostConstruct;

/**
 * This class has the operations that we are going to make with only one value in the request.
 * 
 * @author ChaoticPython
 *
 */
@Component
public class OperationOneValueDao {

  /**
   * This instance must contain the necessary operations (only for one value).
   * 
   */
  private Map<String, Function<Double, Double>> operations;

  /**
   * This method initialize a Map and define the operations.
   * 
   */
  @PostConstruct
  public void init() {
    operations = new HashMap<>();
    operations.put("sqrt", value -> Math.sqrt(value));
    operations.put("cbrt", value -> Math.cbrt(value));
    operations.put("exp", value -> Math.exp(value));
    operations.put("abs", value -> Math.abs(value));
  }

  /**
   * This method verify if the operation sent in the request exists. If the operation doesn't
   * exists, then throw an exception.
   * 
   * @param operation as a String with the operation.
   * @param value as the value to evaluate.
   * @return the result (Double) of the operation or an exception if has a problem.
   */
  public Double doOperation(String operation, Double value) {
    if (operations.containsKey(operation)) {
      return operations.get(operation).apply(value);
    } else {
      throw new BadRequestException("The operation doesn't exist, check it.");
    }
  }

}
