package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/** 
 * code written by Supreeth.goud*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	/** 
	 * code written by Snigdha.sree*/
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	 public String getResourceName(){
		 return resourceName;
	 }
	 
	 public String getFeildName() {
		 return fieldName;
	 }
	 
	 public Object getFieldValue() {
		 return fieldValue;
	 }

}
