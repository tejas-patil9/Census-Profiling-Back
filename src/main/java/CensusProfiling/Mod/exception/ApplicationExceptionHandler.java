package CensusProfiling.Mod.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import CensusProfiling.Mod.model.APIError;



@RestControllerAdvice
public class ApplicationExceptionHandler {
	// when a RecordNotFoundException is thrown, then this method is used to catch
	// This can be called by any methods, from users as well as admins.
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<APIError> handleRecordNotFoundException(Exception e) {

		HttpStatus status = HttpStatus.NOT_FOUND;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}

	// when a DuplicateRecordException is thrown, then this method is used to catch
	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<APIError> handleDuplicateRecordException(Exception e) {
		HttpStatus status = HttpStatus.CONFLICT;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}

	// when a NoAccessException is thrown, then this method is used to catch
	@ExceptionHandler(NoAccessException.class)
	public ResponseEntity<APIError> handleNoAccessException(Exception e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}

	// when any other exception is thrown, then this method is used to catch the
	// exception
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<APIError> otherExceptions(Exception e) {
		HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;

		APIError apiError = new APIError();
		apiError.setMsg(e.getMessage());
		apiError.setHttpStatus(status);
		ResponseEntity<APIError> resEntity = new ResponseEntity<>(apiError, status);
		return resEntity;
	}
}

