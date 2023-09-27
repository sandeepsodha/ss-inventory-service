package com.ss.inventoryservice.jms;


import com.ss.inventoryservice.config.ActiveMQConfiguration;
import com.ss.inventoryservice.entity.BusInventory;
import com.ss.inventoryservice.model.Booking;
import com.ss.inventoryservice.service.BusInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.time.LocalDate;
import java.util.Date;

@Component
public class TextSubscriber {

    private static final Logger log = LoggerFactory.getLogger(TextSubscriber.class);

    @Autowired
    private PublisherTextService publisherTextService;
    @Autowired
    private BusInventoryService busInventoryService;
    @JmsListener(destination = ActiveMQConfiguration.INVENTORY_TOPIC)
    public void receiveText(TextMessage textMessage) throws JMSException {
        log.info("Received Payment Details from Payment Service: " + textMessage.getText());

        Long bookingNumber = Long.valueOf(textMessage.getText().split("Payment done for Booking Number ")[1]);

        Booking booking = busInventoryService.getBookingDetails(bookingNumber);

        BusInventory busInventory= busInventoryService.findByBusNumber(booking.getBusNumber());
        busInventory.setAvailableSeats(busInventory.getAvailableSeats() - booking.getNumberOfSeats());
        busInventory.setLastUpdatedDate(LocalDate.now());
        busInventoryService.updateBusInventory(busInventory.getId(),busInventory);
        log.info("Updated Bus Inventory for Bus Number " + booking.getBusNumber());

        publisherTextService.publishText("Updated Bus Inventory for Bus Number " + booking.getBusNumber());
    }

}

