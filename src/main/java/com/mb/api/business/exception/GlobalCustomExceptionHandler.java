package com.mb.api.business.exception;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.mb.api.business.constant.ErrorResponse;

@RestControllerAdvice
public class GlobalCustomExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(value = {CustomException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleCustomException(CustomException ex) {
		return new ErrorResponse(new Date(), ex.getMessage(), ex.getStatusCode().getValue());
	}
	
	
	@ExceptionHandler(value = {NotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse unKnownException(Exception ex)
	{
		return new ErrorResponse(new Date(),  ex.getMessage(), HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse internalServerException(Exception ex)
	{

		return new ErrorResponse(new Date(), ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@ExceptionHandler(value = {AccessDeniedException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse accessDeniedException(Exception ex)
	{
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.FORBIDDEN.value());
	}

	@Override
	@Nullable
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
	{
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach(error -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			errors.put(fieldName, message);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
