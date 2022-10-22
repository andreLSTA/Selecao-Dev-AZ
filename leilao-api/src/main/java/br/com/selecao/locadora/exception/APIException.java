package br.com.selecao.locadora.exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException {
    private HttpStatus httpStatus;

    public APIException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
