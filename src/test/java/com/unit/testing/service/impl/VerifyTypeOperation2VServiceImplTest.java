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
public class VerifyTypeOperation2VServiceImplTest {

	@Mock
	private OperationsDao operationsDAO;
	
	@InjectMocks
	private VerifyTypeOperation2VServiceImpl verifyOperation;
	
	@Test(expected = BadRequestException.class)
	public void verifyTypeOperationFirstError() {
		OperationRequest request = new OperationRequest();
		request.setOption("++");
		verifyOperation.verifyTypeOperation(127.32, 332.432, request.getOption());
	}
	
	@Test(expected = BadRequestException.class)
	public void verifyTypeOperationSecondError() {
		OperationRequest request = new OperationRequest();
		request.setOption("a");
		verifyOperation.verifyTypeOperation(127.32, 332.432, request.getOption());
	}
	
	@Test
	public void verifyTypeOperationSuma() {
		OperationRequest request = new OperationRequest();
		request.setVal1(-19.36);
		request.setVal1(-7.01);
		request.setOption("+");
		Double result = -26.37;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.suma(request.getVal1(), request.getVal2())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getVal2(), request.getOption());
		
		assertNotNull(response);
	}
	
	@Test
	public void verifyTypeOperationResta() {
		OperationRequest request = new OperationRequest();
		request.setVal1(-1.96);
		request.setVal1(51.263);
		request.setOption("-");
		Double result = -53.223;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.resta(request.getVal1(), request.getVal2())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getVal2(), request.getOption());
		
		assertNotNull(response);
	}
	
	@Test
	public void verifyTypeOperationMultiplicacion() {
		OperationRequest request = new OperationRequest();
		request.setVal1(-8.302);
		request.setVal1(-104.0002);
		request.setOption("*");
		Double result = 863.4096604;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.multiplicacion(request.getVal1(), request.getVal2())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getVal2(), request.getOption());
		
		assertNotNull(response);
	}
	
	@Test
	public void verifyTypeOperationDivision() {
		OperationRequest request = new OperationRequest();
		request.setVal1(12.0);
		request.setVal1(2.0);
		request.setOption("/");
		Double result = 6.0;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.division(request.getVal1(), request.getVal2())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getVal2(), request.getOption());
		
		assertNotNull(response);
	}
	
	@Test
	public void verifyTypeOperationPotencia() {
		OperationRequest request = new OperationRequest();
		request.setVal1(1.0);
		request.setVal1(5421.3);
		request.setOption("^");
		Double result = 1.0;
		
		ResultResponse previewResponse = generateResponse(result);
		Mockito.when(operationsDAO.potencia(request.getVal1(), request.getVal2())).thenReturn(previewResponse.getResultado());
		
		ResultResponse response = verifyOperation.verifyTypeOperation(request.getVal1(), request.getVal2(), request.getOption());
		
		assertNotNull(response);
	}
	
	private ResultResponse generateResponse(Double value) {
		// TODO Auto-generated method stub
		ResultResponse response = new ResultResponse();
		response.setResultado(value);
		return response;
	}
	
}
