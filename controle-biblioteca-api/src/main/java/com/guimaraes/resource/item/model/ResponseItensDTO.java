package com.guimaraes.resource.item.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseItensDTO {

	private int count;
	private List<ItemDTO> itens;

}
