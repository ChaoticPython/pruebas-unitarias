package com.unit.testing.dao;

import org.springframework.stereotype.Component;

/**
 * This class contains the operations available for the users requests.
 * 
 * @author JulioPachecoSanginez
 *
 */
@Component
public class OperationsDao {

  /**
   * This method does the 'sum' operation.
   * 
   * @param val1.
   * @param val2.
   * @return the result of the sum of two numbers.
   */
  // Operación SUMA
  public Double suma(Double val1, Double val2) {
    return val1 + val2;
  }

  /**
   * This method does the 'subtraction' operation .
   * 
   * @param val1.
   * @param val2.
   * @return the result of the subtraction of two numbers.
   */
  // Operación RESTA
  public Double resta(Double val1, Double val2) {
    return val1 - val2;
  }

  /**
   * This method does the 'multiplication' operation.
   * 
   * @param val1.
   * @param val2.
   * @return the result of the multiplication of two numbers.
   */
  // Operación MULTIPLICACION
  public Double multiplicacion(Double val1, Double val2) {
    return val1 * val2;
  }

  /**
   * This method does the 'division' operation.
   * 
   * @param val1.
   * @param val2.
   * @return the result of the division of two numbers.
   */
  // Operación DIVISION
  public Double division(Double val1, Double val2) {
    return val1 / val2;
  }

  /**
   * This method does the 'power' operation.
   * 
   * @param val1 is the number to elevate.
   * @param val2 is the value for power.
   * @return the result of the power of a number.
   */
  // Operación POTENCIA
  public Double potencia(Double val1, Double val2) {
    return Math.pow(val1, val2);
  }

  /**
   * This method does the 'square root' operation.
   * 
   * @param val.
   * @return the result of the square root of the parameter.
   */
  // Operación RAIZ CUADRADA
  public Double raizCuadrada(Double val) {
    return Math.sqrt(val);
  }

  /**
   * This method does the 'cubic root' operation.
   * 
   * @param val.
   * @return the result of the cubic root of the parameter.
   */
  // Operación RAIZ CUBICA
  public Double raizCubica(Double val) {
    return Math.cbrt(val);
  }

  /**
   * This method does the 'exponential function'.
   * 
   * @param val.
   * @return the result of the exponential function of the parameter.
   */
  // Operación EXPONENTE
  public Double exponente(Double val) {
    return Math.exp(val);
  }

  /**
   * This method does the 'absolute value'.
   * 
   * @param val.
   * @return the result of the absolute value of the parameter.
   */
  // Operación VALOR ABSOLUTO
  public Double valorAbsoluto(Double val) {
    return Math.abs(val);
  }

}
