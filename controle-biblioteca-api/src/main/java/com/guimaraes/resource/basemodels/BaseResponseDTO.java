package com.guimaraes.resource.basemodels;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BaseResponseDTO implements Serializable {

	private static final long serialVersionUID = 5681822913336246050L;
	HttpStatus httpStatus;

}
