package com.guimaraes.resource.item.model;

import java.util.List;

import com.guimaraes.resource.basemodels.BaseResponseDTO;

import lombok.Data;

@Data
public class ResponseItensDTO extends BaseResponseDTO {

	private static final long serialVersionUID = -4306968722350182574L;

	private int count;
	private int offset;
	private int limit;
	private int total;
	private List<ItemDTO> itens;

	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;

		if (itens != null)
			count = itens.size();
	}

	public List<ItemDTO> getItens() {

		if (itens != null)
			count = itens.size();

		return this.itens;
	}

}
