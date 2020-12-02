package br.com.projuris.procontrol.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projuris.procontrol.models.Client;
import br.com.projuris.procontrol.models.Equipment;
import br.com.projuris.procontrol.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable("id") long id) {
        Optional<Equipment> equipment = orderService.getEquipmentById(id);

        if (equipment.isPresent()) {
            return ResponseEntity.ok(equipment.get());
        }

        return ResponseEntity.notFound().header("Order not found", "There's no order with this id").build();
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Equipment equipment) {
        Optional<Equipment> newEquipment = orderService.createOrder(equipment);
        if (newEquipment.isPresent()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping("/pending")
    public ResponseEntity<Equipment> getOrderByReponsibleName(@RequestParam("name") String responsibleName) {
        Optional<Equipment> equipment = orderService.getEquipmentByResponsibleName(responsibleName);

        if (equipment.isPresent()) {
            return ResponseEntity.ok(equipment.get());
        }

        return ResponseEntity.notFound().header("Order not found", "There's no order with this responsible").build();
    }

    @PutMapping
    public ResponseEntity<String> updateOrderStatus(@RequestBody Equipment newStatus) {
        orderService.updateOrderStatus(newStatus);

        return ResponseEntity.ok("Updated");
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(orderService.getAllClients());
    }
}