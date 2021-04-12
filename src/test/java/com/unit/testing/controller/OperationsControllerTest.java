package com.unit.testing.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyRequestService;

@RunWith(MockitoJUnitRunner.class)
public class OperationsControllerTest {

	@Mock
	private IVerifyRequestService verifyRequest;
	
	@InjectMocks
	private OperationsController operationController;
	
	@Test
	public void testRetrieveResult() {
		ResultResponse previewResponse = new ResultResponse();
		
		Mockito.when(verifyRequest.retrieveResultResponse(Mockito.any())).thenReturn(previewResponse);
		
		ResponseEntity<ResultResponse> response = operationController.retrieveResult(Mockito.any());
		
		assertNotNull(response);
	}
	
}
