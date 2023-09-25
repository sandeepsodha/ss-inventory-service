package com.ss.inventoryservice.api;

import com.ss.inventoryservice.entity.BusInventory;
import com.ss.inventoryservice.service.BusInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/businventorys")
public class BusInventoryController {

    @Autowired
    private BusInventoryService busInventoryService;

    @GetMapping("/")
    public List<BusInventory> getAllBusInventory() {
        return busInventoryService.findAllBusInventory();
    }

    @GetMapping("/{id}")
    public BusInventory getBusInventoryById(@PathVariable Long id) {
        return busInventoryService.findById(id);
    }

    @PostMapping("/")
    public BusInventory addBusInventory(@RequestBody BusInventory busInventory) {
        return busInventoryService.addBusInventory(busInventory);
    }

    @PutMapping("/{id}")
    public BusInventory updateBusInventory(@PathVariable Long id, @RequestBody BusInventory updatedBusInventory) {
        return busInventoryService.updateBusInventory(id,updatedBusInventory);
    }

    @DeleteMapping("/{id}")
    public void deleteBusInventory(@PathVariable Long id) {
        busInventoryService.deleteBusInventory(id);
    }
}
