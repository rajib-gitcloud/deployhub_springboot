package com.deployhub.springboot.controller;

import com.deployhub.springboot.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final List<Item> items = new ArrayList<>(List.of(
        new Item(1L, "Configure Spring Boot 3 App", "Completed"),
        new Item(2L, "Setup Spring Actuator Probes", "Completed"),
        new Item(3L, "Deploy to Cloud Container", "Ready")
    ));
    private final AtomicLong counter = new AtomicLong(3);

    @GetMapping
    public ResponseEntity<Map<String, Object>> getItems() {
        return ResponseEntity.ok(Map.of(
            "items", items,
            "count", items.size()
        ));
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
        Item item = new Item(counter.incrementAndGet(), newItem.title(), "Pending");
        items.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
