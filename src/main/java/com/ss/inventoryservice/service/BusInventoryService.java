package com.ss.inventoryservice.service;

import com.ss.inventoryservice.entity.BusInventory;
import com.ss.inventoryservice.model.Booking;
import com.ss.inventoryservice.repository.BusInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class BusInventoryService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private BusInventoryRepository busInventoryRepository;

    public List<BusInventory> findAllBusInventory() {
        return busInventoryRepository.findAll();
    }

    public BusInventory findById(Long id) {
        return busInventoryRepository.findById(id).orElse(null);
    }

    public BusInventory findByBusNumber(Long busNumber) {
        return busInventoryRepository.findByBusNumber(busNumber).orElse(null);
    }

    public BusInventory addBusInventory(BusInventory busInventory) {
        return busInventoryRepository.save(busInventory);
    }

    public BusInventory updateBusInventory(Long id, BusInventory updatedBusInventory) {
        return busInventoryRepository.findById(id)
                .map(busInventory -> {
                    busInventory.setBusNumber(updatedBusInventory.getBusNumber());
                    busInventory.setAvailableSeats(updatedBusInventory.getAvailableSeats());
                    busInventory.setLastUpdatedDate(updatedBusInventory.getLastUpdatedDate());
                    return busInventoryRepository.save(busInventory);
                })
                .orElse(null);

    }

    public void deleteBusInventory(@PathVariable Long id) {
        busInventoryRepository.deleteById(id);
    }

    public Booking getBookingDetails(Long bookingNumber){
        return webClient.get()
                .uri("localhost:9072/booking-service/bookings/" + bookingNumber)
                .retrieve()
                .bodyToMono(Booking.class)
                .block();
    }
}
