package com.unit.testing.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.unit.testing.dao.OperationsDao;
import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;

@RunWith(MockitoJUnitRunner.class)
public class VerifyTypeOperation1VServiceImplTest {

	@Mock
	private OperationsDao operationsDAO;
	
	@InjectMocks
	private VerifyTypeOperation1VServiceImpl verifyOperation;
	
	@Test(expected = BadRequestException.class)
	public void testVerifyTypeOperationError() {
		OperationRequest request = new OperationRequest();
		request.setVal1(3121.21);
		request.setOption("other");
		
		verifyOperation.verifyTypeOperation(request.getVal1(), request.getOption());
	}
	
	@Test
	public void testVerifyTypeOperationSqrt() {
		OperationRequest request = new OperationRequest();
		request.setVal1(100.0);
		request.setOption("sqrt");
		Double result = 10.0;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.raizCuadrada(request.getVal1())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getOption());
		
		assertNotNull(response);
	}
	
	@Test
	public void testVerifyTypeOperationCbrt() {
		OperationRequest request = new OperationRequest();
		request.setVal1(8.0);
		request.setOption("cbrt");
		Double result = 2.0;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.raizCubica(request.getVal1())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getOption());
		
		assertNotNull(response);
	}
	
	@Test
	public void testVerifyTypeOperationExp() {
		OperationRequest request = new OperationRequest();
		request.setVal1(1.0);
		request.setOption("exp");
		Double result = 2.718281828459045;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.exponente(request.getVal1())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getOption());
		
		assertNotNull(response);
	}

	@Test
	public void testVerifyTypeOperationAbs() {
		OperationRequest request = new OperationRequest();
		request.setVal1(-27.0);
		request.setOption("abs");
		Double result = 27.0;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.valorAbsoluto(request.getVal1())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getOption());
		
		assertNotNull(response);
	}
	
	private ResultResponse generateResponse(Double value) {
		// TODO Auto-generated method stub
		ResultResponse response = new ResultResponse();
		response.setResultado(value);
		return response;
	}
	
}
