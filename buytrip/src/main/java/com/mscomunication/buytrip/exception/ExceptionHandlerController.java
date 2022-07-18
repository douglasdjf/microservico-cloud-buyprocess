package com.mscomunication.buytrip.exception;

import com.mscomunication.buytrip.exception.model.ErrorException;
import com.mscomunication.buytrip.exception.model.MessageError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseEntity<MessageError> process(MethodArgumentNotValidException ex) {

        return ResponseEntity.badRequest()
                    .body(MessageError.builder()
                            .timestamp(LocalDateTime.now())
                            .messagem("Dados inválidos!")
                            .status(HttpStatus.BAD_REQUEST.value())
                            .erros(
                                    ex.getBindingResult()
                                            .getAllErrors()
                                            .stream()
                                            .map(exp -> ErrorException.builder().messagem(exp.getDefaultMessage()).build())
                                            .collect(Collectors.toList())
                            )
                            .build()
                    );
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<MessageError> process(HttpMessageNotReadableException ex) {

        return ResponseEntity.badRequest()
                              .body(MessageError.builder()
                                      .timestamp(LocalDateTime.now())
                                      .messagem("Formato não válido!")
                                      .status(HttpStatus.BAD_REQUEST.value())
                                      .build()
                              );
    }

}
