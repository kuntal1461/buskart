package com.buskart.search.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "buskart_booking", indexes = {
    @Index(name = "idx_booking_id", columnList = "booking_id")
})
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BuskartBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "booking_id", nullable = false, unique = true)
    private String bookingId;  // Unique booking number

    @Column(name = "user_id", nullable = false)
    private String userId;  // ID of the user who made the booking (Foreign Key)

    @Column(name = "customer_name", nullable = false)
    private String customerName;  // Name of the customer

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;  // Date of booking

    @Column(name = "status", nullable = false)
    private String status;  // Booking status (Confirmed, Cancelled, etc.)

    @Column(name = "amount")
    private String amount;  // Amount paid

    @Column(name = "destination", nullable = false)
    private String destination;  // Destination of the booking

    @Column(name = "source", nullable = false)
    private String source;  // Starting point of the booking

    @Column(name = "seat_number")
    private String seatNumber;  // Seat number for the booking

    @Column(name = "bus_type")
    private String busType;  // Type of bus (AC, Non-AC, etc.)

    @Column(name = "field1")
    private String field1;  // Extra field 1 for additional data

    @Column(name = "field2")
    private String field2;  // Extra field 2 for additional data

    @Column(name = "field3")
    private String field3;  // Extra field 3 for additional data

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;  // Auto-created timestamp

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;  // Auto-updated timestamp

}
