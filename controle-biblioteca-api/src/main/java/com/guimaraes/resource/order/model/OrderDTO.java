package com.guimaraes.resource.order.model;

import java.util.ArrayList;
import java.util.List;

import com.guimaraes.resource.basemodels.BaseRequestDTO;

import lombok.Data;

@Data
public class OrderDTO extends BaseRequestDTO {

	private static final long serialVersionUID = 5853939616400431325L;
	private int count;
	private List<ItemOrderDTO> itens;

	public OrderDTO() {
		itens = new ArrayList<>();
	}

	public void setItens(List<ItemOrderDTO> itens) {
		this.itens = itens;

		if (itens != null)
			count = itens.size();
	}

	public List<ItemOrderDTO> getItens() {

		if (itens != null)
			count = itens.size();

		return this.itens;
	}

}
