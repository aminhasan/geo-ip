package hr.biss.geoip.resource.error;

import hr.biss.geoip.resource.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.net.UnknownHostException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleHttpClientErrorException(HttpClientErrorException ex) {

        ErrorDto errorDto = new ErrorDto(HttpStatus.NOT_FOUND, "Invalid request", ex.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnknownHostException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleUnknownHostException(UnknownHostException ex) {

        ErrorDto errorDto = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid host name", ex.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
