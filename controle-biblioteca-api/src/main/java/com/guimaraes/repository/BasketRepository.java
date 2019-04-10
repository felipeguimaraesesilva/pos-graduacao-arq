package com.guimaraes.repository;

import com.guimaraes.resource.basket.model.BasketDTO;

import lombok.Data;

@Data
public class BasketRepository {
	private BasketDTO basketMemory = new BasketDTO();

}
