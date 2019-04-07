package com.guimaraes.resource.rent;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.resource.rent.model.RentDTO;

@RestController
@RequestMapping("/itens/rents")
public class RentController {

	@PostMapping
	public RentDTO createRent(RentDTO rent) {
		return null;
	}

}
