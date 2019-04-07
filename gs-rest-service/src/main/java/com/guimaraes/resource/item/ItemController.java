package com.guimaraes.resource.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.resource.item.model.ItemDTO;

@RestController
@RequestMapping("/itens")
public class ItemController {

	@GetMapping
	public List<ItemDTO> getItens() {
		List<ItemDTO> result = new ArrayList<>();

		for (int i = 1; i < 100; i++) {
			result.add(new ItemDTO("id" + i, "Book - " + i, "Guimarães, Felipe"));
		}

		return result;
	}

	@PostMapping
	public ItemDTO createItem(ItemDTO item) {
		item.setOid("<new> OID");
		return item;
	}

}
