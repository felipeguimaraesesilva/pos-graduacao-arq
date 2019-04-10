package com.guimaraes.resource.basket.model;

import com.guimaraes.resource.basemodels.BaseResponseDTO;

import lombok.Data;

@Data
public class ResponseBasketDTO extends BaseResponseDTO {

	private static final long serialVersionUID = 9045545450333947748L;

	private BasketDTO basketDTO;

}
