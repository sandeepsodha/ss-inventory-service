package com.ss.inventoryservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Booking {
    private Long bookingNumber;
    private Long busNumber;
    private Date bookingDate;
    private String source;
    private String destination;
    private int numberOfSeats;
    private String status;

}
