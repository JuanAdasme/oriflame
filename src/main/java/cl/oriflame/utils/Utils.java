package cl.oriflame.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class Utils {
	
	public static <T> ResponseEntity<?> ok(T response) {
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public static ResponseEntity<?> badRequest() {
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<?> serverError() {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<?> notFound() {
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
