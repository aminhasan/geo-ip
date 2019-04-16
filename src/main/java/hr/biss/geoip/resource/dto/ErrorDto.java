package hr.biss.geoip.resource.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorDto {

    private LocalDateTime timeOfError;
    private HttpStatus status;
    private int statusCode;
    private String message;
    private String cause;

    public ErrorDto(HttpStatus status, String message, String cause) {
        this.timeOfError = LocalDateTime.now();
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
        this.cause = cause;
    }
}
