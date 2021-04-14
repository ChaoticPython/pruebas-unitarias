package com.unit.testing.dao;

import org.springframework.stereotype.Component;

@Component
public class OperationsDao {

  // Operación SUMA
  public Double suma(Double val1, Double val2) {
    return val1 + val2;
  }

  // Operación RESTA
  public Double resta(Double val1, Double val2) {
    return val1 - val2;
  }

  // Operación MULTIPLICACION
  public Double multiplicacion(Double val1, Double val2) {
    return val1 * val2;
  }

  // Operación DIVISION
  public Double division(Double val1, Double val2) {
    return val1 / val2;
  }

  // Operación POTENCIA
  public Double potencia(Double val1, Double val2) {
    return Math.pow(val1, val2);
  }

  // Operación RAIZ CUADRADA
  public Double raizCuadrada(Double val) {
    return Math.sqrt(val);
  }

  // Operación RAIZ CUBICA
  public Double raizCubica(Double val) {
    return Math.cbrt(val);
  }

  // Operación EXPONENTE
  public Double exponente(Double val) {
    return Math.exp(val);
  }

  // Operación VALOR ABSOLUTO
  public Double valorAbsoluto(Double val) {
    return Math.abs(val);
  }

}
