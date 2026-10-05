package org.example.demoksv.customexception.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demoksv.customexception.EmployeeNotFoundException;
import org.example.demoksv.dto.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler =
            new GlobalExceptionHandler();

    @BeforeEach
    void setUp() {
    }

    @Test
    void handleEmployeeNotFound() {

        // Arrange
        EmployeeNotFoundException exception =
                new EmployeeNotFoundException(
                        "Employee not found with id: 999"
                );

        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getRequestURI())
                .thenReturn("/employees/999");

        // Act
        ResponseEntity<ErrorResponse> response =
                handler.handleEmployeeNotFound(exception, request);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertNotNull(response.getBody());

        assertEquals(404, response.getBody().status());
        assertEquals("NOT_FOUND", response.getBody().error());
        assertEquals(
                "Employee not found with id: 999",
                response.getBody().message()
        );
        assertEquals(
                "/employees/999",
                response.getBody().path()
        );

        verify(request).getRequestURI();
    }


    @Test
    void handleValidation() {
    }

    @Test
    void handleGenericException() {
    }
}