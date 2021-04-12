package com.unit.testing.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.unit.testing.dao.OperationsDao;

public class OperacionesDaoTest {

	OperationsDao operations = new OperationsDao();
	
	@Test
	public void testSuma() {
		Double expected = 25.4;
		Double result = operations.suma(7.1, 18.3);
		assertEquals(expected, result);
	}
	
	@Test
	public void testResta() {
		Double expected = -125.10000000000002;
		Double result = operations.resta(312.62, 437.72);
		assertEquals(expected, result);
	}
	
	@Test
	public void testMultiplicacion() {
		Double expected = 256.0;
		Double result = operations.multiplicacion(64.0, 4.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testDivision() {
		Double expected = 256.0;
		Double result = operations.division(512.0, 2.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testPotencia() {
		Double expected = 32768.0;
		Double result = operations.potencia(2.0, 15.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testRaizCuadrada() {
		Double expected = 10.0;
		Double result = operations.raizCuadrada(100.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testRaizCubica() {
		Double expected = 2.0;
		Double result = operations.raizCubica(8.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testExponente() {
		Double expected = 2.718281828459045;
		Double result = operations.exponente(1.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testValorAbsoluto() {
		Double expected = 11208.3293;
		Double result = operations.valorAbsoluto(11208.3293);
		assertEquals(expected, result);
	}

}
