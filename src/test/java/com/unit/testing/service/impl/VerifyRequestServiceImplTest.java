package com.unit.testing.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.unit.testing.exception.BadRequestException;
import com.unit.testing.model.OperationRequest;
import com.unit.testing.model.ResultResponse;
import com.unit.testing.service.IVerifyTypeOperation1VService;
import com.unit.testing.service.IVerifyTypeOperation2VService;

@RunWith(MockitoJUnitRunner.class)
public class VerifyRequestServiceImplTest {

	@Mock
	private IVerifyTypeOperation1VService verifyOperation1Value;
	
	@Mock
	private IVerifyTypeOperation2VService verifyOperation2Value;
	
	@InjectMocks
	private VerifyRequestServiceImpl verifyRequest;
	
	@Test(expected = BadRequestException.class)
	public void retrieveResultResponseAllNull() {
		OperationRequest request = new OperationRequest();
		request.setVal1(null);
		request.setVal2(null);
		request.setOption(null);
		
		verifyRequest.retrieveResultResponse(request);
	}
	
	@Test(expected = BadRequestException.class)
	public void retrieveResultResponse2VNull() {
		OperationRequest request = new OperationRequest();
		request.setVal1(null);
		request.setVal2(null);
		request.setOption("any");
		
		verifyRequest.retrieveResultResponse(request);
	}
	
	@Test(expected = BadRequestException.class)
    public void retrieveResultResponseVal2Null() {
        OperationRequest request = new OperationRequest();
        request.setVal1(98.31);
        request.setVal2(null);
        request.setOption(null);
        
        verifyRequest.retrieveResultResponse(request);
    }
	
	@Test(expected = BadRequestException.class)
	public void retrieveResultResponseVal1Null() {
		OperationRequest request = new OperationRequest();
		request.setVal1(null);
		request.setVal2(9823.121);
		request.setOption(null);
		
		verifyRequest.retrieveResultResponse(request);
	}
	
	@Test(expected = BadRequestException.class)
    public void retrieveResultResponseOptionNull() {
        OperationRequest request = new OperationRequest();
        request.setVal1(1.2192);
        request.setVal2(31.21);
        request.setOption(null);
        
        verifyRequest.retrieveResultResponse(request);
    }
	
	@Test
    public void retrieveResultResponseWithFirstValue() {
        OperationRequest request = new OperationRequest();
        request.setVal1(1.2192);
        request.setVal2(null);
        request.setOption("option");
        
        ResultResponse previewResponse = new ResultResponse();
        Mockito.when(verifyOperation1Value.verifyTypeOperation(request.getVal1(), request.getOption()))
            .thenReturn(previewResponse);
        
        ResultResponse response = verifyRequest.retrieveResultResponse(request);
        
        assertNotNull(response);
    }
	
	@Test
    public void retrieveResultResponseWithSecondValue() {
        OperationRequest request = new OperationRequest();
        request.setVal1(null);
        request.setVal2(31.21);
        request.setOption("option");
        
        ResultResponse previewResponse = new ResultResponse();
        Mockito.when(verifyOperation1Value.verifyTypeOperation(request.getVal2(), request.getOption()))
            .thenReturn(previewResponse);
        
        ResultResponse response = verifyRequest.retrieveResultResponse(request);
        
        assertNotNull(response);
    }
	
	@Test
	public void retrieveResultResponseWithValues() {
		OperationRequest request = new OperationRequest();
		request.setVal1(1.2192);
		request.setVal2(31.21);
		request.setOption("option");
		
		ResultResponse previewResponse = new ResultResponse();
		Mockito.when(verifyOperation2Value.verifyTypeOperation(request.getVal1(), request.getVal2(), request.getOption()))
			.thenReturn(previewResponse);
		
		ResultResponse response = verifyRequest.retrieveResultResponse(request);
		
		assertNotNull(response);	
	}
	
}
