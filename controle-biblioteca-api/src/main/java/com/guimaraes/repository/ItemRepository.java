package com.guimaraes.repository;

import java.util.ArrayList;
import java.util.List;

import com.guimaraes.resource.item.model.ItemDTO;

import lombok.Data;

@Data
public class ItemRepository {
	private List<ItemDTO> booksMemory = new ArrayList<>();

	public ItemRepository() {
		for (int i = 1; i < 100; i++) {
			booksMemory.add(new ItemDTO("id" + i, "Book - " + i, "Guimarães, Felipe"));
		}
	}
}
