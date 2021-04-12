package com.unit.testing.exception;

import com.unit.testing.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
  * Manejamos una excepción de tipo BAD REQUEST
  *
  * @author jeps
  * @version 1.0
  * @return Response Entity w/ BAD REQUEST
  * @exception Bad Request
  */
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException bre,
      WebRequest wr) {
    ErrorResponse er = new ErrorResponse();
    er.setType("error");
    er.setCode("400 - " + HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase());
    er.setDetails(bre.getMessage());
    return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
  }

}
