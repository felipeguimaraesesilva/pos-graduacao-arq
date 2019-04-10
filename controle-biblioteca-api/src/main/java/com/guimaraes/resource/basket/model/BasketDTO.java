package com.guimaraes.resource.basket.model;

import java.util.ArrayList;
import java.util.List;

import com.guimaraes.resource.basemodels.BaseRequestDTO;

import lombok.Data;

@Data
public class BasketDTO extends BaseRequestDTO {

	private static final long serialVersionUID = 5853939616400431325L;
	private int count;
	private List<ItemBasketDTO> itens;

	public BasketDTO() {
		itens = new ArrayList<>();
	}

	public void setItens(List<ItemBasketDTO> itens) {
		this.itens = itens;

		if (itens != null)
			count = itens.size();
	}

	public List<ItemBasketDTO> getItens() {

		if (itens != null)
			count = itens.size();

		return this.itens;
	}

}
