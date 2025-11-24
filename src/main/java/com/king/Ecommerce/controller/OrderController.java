package com.king.Ecommerce.controller;

import com.king.Ecommerce.model.dto.OrderRequest;
import com.king.Ecommerce.model.dto.OrderResponse;
import com.king.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) throws IOException {
        return new ResponseEntity<>(orderService.placeOrder(orderRequest), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> getAllOrderResponses() {
        return new ResponseEntity<>(orderService.getAllOrderResponses(), HttpStatus.OK);
    }
}
