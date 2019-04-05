package com.guimaraes.resource.item.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.resource.item.model.Item;

@RestController
@RequestMapping("/itens")
public class ItemController {
	
	@ResponseBody
	public List<Item> itens(){
		List<Item> response = new ArrayList<>();
		
		
		return response;
	}


}
