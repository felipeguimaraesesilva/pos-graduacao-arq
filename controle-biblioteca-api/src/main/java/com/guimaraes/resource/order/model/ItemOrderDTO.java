package com.guimaraes.resource.order.model;

import java.math.BigDecimal;

import com.guimaraes.resource.basemodels.BaseRequestDTO;

import lombok.Data;

@Data
public class ItemOrderDTO extends BaseRequestDTO {

	private static final long serialVersionUID = -8224452615108927690L;
	private String oidItem;
	private BigDecimal price;
	private String status;

}
