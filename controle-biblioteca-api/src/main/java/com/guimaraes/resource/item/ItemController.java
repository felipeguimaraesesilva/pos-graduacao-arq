package com.guimaraes.resource.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.resource.item.model.ItemDTO;
import com.guimaraes.resource.item.model.ResponseItensDTO;

@RestController
@RequestMapping("/itens")
public class ItemController {
	List<ItemDTO> booksMemory = new ArrayList<>();

	public ItemController() {
		for (int i = 1; i < 100; i++) {
			booksMemory.add(new ItemDTO("id" + i, "Book - " + i, "Guimarães, Felipe"));
		}
	}

	@GetMapping
	public ResponseItensDTO getItens() {
		ResponseItensDTO response = new ResponseItensDTO();
		response.setCount(booksMemory.size());
		response.setItens(booksMemory);

		return response;
	}

	@PostMapping
	public ItemDTO createItem(@RequestBody ItemDTO item) {
		item.setOid("id" + (booksMemory.size() + 1));
		booksMemory.add(item);
		return item;
	}

}
