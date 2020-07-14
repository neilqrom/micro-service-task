package org.example.microservicetask.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler({ BussinessException.class })
	@ResponseBody
	public ResponseEntity<Object> handleException(HttpServletRequest request, HttpServletResponse response,
															BussinessException objBussinessException, Locale objLocale) {

		return new ResponseEntity<>(null, objBussinessException.getHttpStatus());
	}

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Object handleException2(HttpServletRequest request, HttpServletResponse response, Exception e) {
		e.printStackTrace();
		return null;
	}
}
