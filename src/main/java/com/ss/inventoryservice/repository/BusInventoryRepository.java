package com.ss.inventoryservice.repository;

import com.ss.inventoryservice.entity.BusInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusInventoryRepository extends JpaRepository<BusInventory, Long> {
}