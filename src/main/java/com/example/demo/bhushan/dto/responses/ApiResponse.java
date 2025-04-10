package com.example.demo.bhushan.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private String message;
    private boolean error;
    private HttpStatus status;

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, message, false, HttpStatus.OK);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus status) {
        return new ApiResponse<>(null, message, true, status);
    }
}
