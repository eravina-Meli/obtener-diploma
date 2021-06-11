package com.digitalhouse.obtenerdiploma.excepciones;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ObtenerDiplomaExceptionController {

    private ErrorDTO errorDTO;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleMethodArgumentNotValid (MethodArgumentNotValidException e){
        errorDTO = new ErrorDTO(e.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidFormatException.class)
    protected ResponseEntity<ErrorDTO> NumberFormatException(InvalidFormatException e ){
        errorDTO  = new ErrorDTO(" Error - El valor de la nota: " + e.getValue().toString() + " debe ser numérico.",
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
