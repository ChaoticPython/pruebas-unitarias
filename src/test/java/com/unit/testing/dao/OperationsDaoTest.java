package com.unit.testing.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This is the unit test for our OperationsDao class.
 * 
 * @author JulioPachecoSanginez
 *
 */
public class OperationsDaoTest {

  /**
   * An instance for do our operations.
   */
  OperationsDao operations = new OperationsDao();

  /**
   * Given two numbers.
   * When we do the 'add' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testSuma() {
    Double expected = 25.4;
    Double result = operations.suma(7.1, 18.3);
    assertEquals(expected, result);
  }

  /**
   * Given two numbers.
   * When we do the 'subtraction' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testResta() {
    Double expected = -125.10000000000002;
    Double result = operations.resta(312.62, 437.72);
    assertEquals(expected, result);
  }

  /**
   * Given two numbers.
   * When we do the 'multiplication' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testMultiplicacion() {
    Double expected = 256.0;
    Double result = operations.multiplicacion(64.0, 4.0);
    assertEquals(expected, result);
  }

  /**
   * Given two numbers.
   * When we do the 'division' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testDivision() {
    Double expected = 256.0;
    Double result = operations.division(512.0, 2.0);
    assertEquals(expected, result);
  }

  /**
   * Given two numbers.
   * When we do the 'power' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testPotencia() {
    Double expected = 32768.0;
    Double result = operations.potencia(2.0, 15.0);
    assertEquals(expected, result);
  }

  /**
   * Given a numbers.
   * When we do the 'square root' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testRaizCuadrada() {
    Double expected = 10.0;
    Double result = operations.raizCuadrada(100.0);
    assertEquals(expected, result);
  }

  /**
   * Given a numbers.
   * When we do the 'cubic root' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testRaizCubica() {
    Double expected = 2.0;
    Double result = operations.raizCubica(8.0);
    assertEquals(expected, result);
  }

  /**
   * Given a number.
   * When we apply the 'exponential' function.
   * Then we get the result of the function.
   */
  @Test
  public void testExponente() {
    Double expected = 2.718281828459045;
    Double result = operations.exponente(1.0);
    assertEquals(expected, result);
  }

  /**
   * Given a number.
   * When we do the 'absolute value' operation.
   * Then we get the result of the operation.
   */
  @Test
  public void testValorAbsoluto() {
    Double expected = 11208.3293;
    Double result = operations.valorAbsoluto(11208.3293);
    assertEquals(expected, result);
  }

}
