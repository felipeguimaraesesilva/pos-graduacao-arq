package com.guimaraes.resource.basket;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.repository.BasketRepository;
import com.guimaraes.resource.basket.model.BasketDTO;
import com.guimaraes.resource.basket.model.ItemBasketDTO;
import com.guimaraes.resource.basket.model.ResponseBasketDTO;

@RestController
@RequestMapping("/basket")
public class BasketController {

	BasketRepository basketRepository = new BasketRepository();

	@GetMapping
	public ResponseEntity<ResponseBasketDTO> getBasket() {
		ResponseBasketDTO response = new ResponseBasketDTO();
		response.setBasketDTO(basketRepository.getBasketMemory());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ResponseBasketDTO> createNewItemOnBasket(@RequestBody BasketDTO basketRequest) {
		ResponseBasketDTO response = new ResponseBasketDTO();

		if (basketRequest != null && basketRequest.getItens() != null) {
			basketRepository.getBasketMemory().getItens().addAll(basketRequest.getItens());

			response.setBasketDTO(basketRepository.getBasketMemory());
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "item/{itemOid}")
	public ResponseEntity<ResponseBasketDTO> deletetemOnBasket(@PathVariable("itemOid") String itemOid) {
		ResponseBasketDTO response = new ResponseBasketDTO();

		if (itemOid != null) {
			List<ItemBasketDTO> newList = basketRepository.getBasketMemory().getItens().stream()
					.filter(i -> !i.getOidItem().equals(itemOid)).collect(Collectors.toList());

			basketRepository.getBasketMemory().setItens(newList);
			response.setBasketDTO(basketRepository.getBasketMemory());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

}
