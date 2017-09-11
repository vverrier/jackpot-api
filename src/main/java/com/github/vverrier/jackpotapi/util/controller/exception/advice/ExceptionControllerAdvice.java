package com.github.vverrier.jackpotapi.util.controller.exception.advice;

import com.github.vverrier.jackpotapi.util.exception.BusinessException;
import com.github.vverrier.jackpotapi.util.exception.BusinessNotFoundException;
import com.github.vverrier.jackpotapi.util.exception.TechnicalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vverrier
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(TechnicalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleTechnicalException(TechnicalException te) {
        // TODO: LOG ERROR MESSAGE
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBusinessException(BusinessException be) {
        // TODO: LOG ERROR MESSAGE
    }

    @ExceptionHandler(BusinessNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleBusinessNotFoundException(BusinessNotFoundException bnfe) {
        // TODO: LOG ERROR MESSAGE
    }


}
