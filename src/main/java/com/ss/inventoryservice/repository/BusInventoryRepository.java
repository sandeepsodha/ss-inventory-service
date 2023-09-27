package com.ss.inventoryservice.repository;

import com.ss.inventoryservice.entity.BusInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusInventoryRepository extends JpaRepository<BusInventory, Long> {
    Optional<BusInventory> findByBusNumber(Long busNumber);

}