package com.king.Ecommerce.service;

import com.king.Ecommerce.model.Order;
import com.king.Ecommerce.model.dto.OrderItemResponse;
import com.king.Ecommerce.model.dto.OrderRequest;
import com.king.Ecommerce.model.dto.OrderResponse;
import com.king.Ecommerce.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) throws IOException {
        Order order = new Order();
        order.setOrderId("ORD" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());
        order.setEmail(orderRequest.email());
        order.setCustomerName(orderRequest.customerName());
        order.setOrderDate(LocalDate.now());
        order.setStatus("PLACED");
        order.setOrderItems(orderRequest.orderItemRequest().stream((a) = > a.));
    }

    public List<OrderResponse> getAllOrderResponses() {
        return orderRepo.findAll();
    }
}
