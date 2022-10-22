package br.com.selecao.locadora.exception;

import br.com.selecao.locadora.dto.response.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleBusinessException(Exception exception) {
        exception.printStackTrace();
        ResponseDTO responseDTO = new ResponseDTO(false, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = APIException.class)
    public ResponseEntity<Object> handleBusinessException(APIException APIException) {
        ResponseDTO responseDTO = new ResponseDTO(false, APIException.getMessage(), APIException.getHttpStatus(), null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        List<ObjectError> listaDeErros = methodArgumentNotValidException.getBindingResult().getAllErrors();
        String mensagemDeErro = listaDeErros.get(0).getDefaultMessage();
        ResponseDTO responseDTO = new ResponseDTO(false, mensagemDeErro, HttpStatus.UNPROCESSABLE_ENTITY, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

}
