package com.unit.testing.exception;

public class BadRequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  // Proporcionamos un mensaje más específico del problema
  public BadRequestException(String message) {
    super(message);
  }

}
