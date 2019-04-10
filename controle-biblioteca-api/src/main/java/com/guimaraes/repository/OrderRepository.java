package com.guimaraes.repository;

import com.guimaraes.resource.order.model.OrderDTO;

import lombok.Data;

@Data
public class OrderRepository {
	private OrderDTO orderMemory = new OrderDTO();

}
