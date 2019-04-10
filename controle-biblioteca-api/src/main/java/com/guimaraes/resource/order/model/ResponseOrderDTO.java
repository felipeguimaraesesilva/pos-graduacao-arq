package com.guimaraes.resource.order.model;

import com.guimaraes.resource.basemodels.BaseResponseDTO;

import lombok.Data;

@Data
public class ResponseOrderDTO extends BaseResponseDTO {

	private static final long serialVersionUID = 9045545450333947748L;

	private OrderDTO basketDTO;

}
