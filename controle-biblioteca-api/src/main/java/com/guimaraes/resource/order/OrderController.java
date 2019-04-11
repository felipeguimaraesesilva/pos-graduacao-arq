package com.guimaraes.resource.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.repository.OrderRepository;
import com.guimaraes.resource.order.model.ItemOrderDTO;
import com.guimaraes.resource.order.model.OrderDTO;
import com.guimaraes.resource.order.model.ResponseOrderDTO;

@RestController
@RequestMapping("/order")
public class OrderController {

	OrderRepository orderMemory = new OrderRepository();

	@GetMapping
	public ResponseEntity<ResponseOrderDTO> getOrders() {
		ResponseOrderDTO response = new ResponseOrderDTO();
		response.setBasketDTO(orderMemory.getOrderMemory());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ResponseOrderDTO> createNewOrder(@RequestBody OrderDTO orderRequest) {
		ResponseOrderDTO response = new ResponseOrderDTO();

		if (orderRequest != null && orderRequest.getItens() != null) {
			orderRequest.getItens().stream().forEach(o -> o.setStatus(Math.random() < 0.5 ? "pendente" : "concluido"));
			orderMemory.getOrderMemory().getItens().addAll(orderRequest.getItens());

			response.setBasketDTO(orderMemory.getOrderMemory());
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/status/done", method = RequestMethod.GET)
	public ResponseEntity<ResponseOrderDTO> getStatusDone() {
		ResponseOrderDTO response = new ResponseOrderDTO();

		List<ItemOrderDTO> resultList = orderMemory.getOrderMemory().getItens().stream()
				.filter(i -> i.getStatus().toLowerCase().contains("concluido")).collect(Collectors.toList());

		OrderDTO basketDTO = new OrderDTO();
		basketDTO.setItens(resultList);

		response.setBasketDTO(basketDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
