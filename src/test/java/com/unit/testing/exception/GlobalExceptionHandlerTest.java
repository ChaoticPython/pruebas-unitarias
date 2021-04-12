package com.unit.testing.exception;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.unit.testing.model.ErrorResponse;

@RunWith(MockitoJUnitRunner.class)
public class GlobalExceptionHandlerTest {

  @Mock
  private WebRequest wr;
  
  @InjectMocks
  private GlobalExceptionHandler geh;
  
  @Test
  public void testHandleBadRequestException() {
    BadRequestException bre = new BadRequestException("Bad Request");
    ResponseEntity<ErrorResponse> response = geh.handleBadRequestException(bre, wr);
    
    assertNotNull(response);
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
  
}
