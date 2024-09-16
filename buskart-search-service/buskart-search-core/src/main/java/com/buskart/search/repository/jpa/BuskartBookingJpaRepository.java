package com.buskart.search.repository.jpa;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buskart.search.entity.BuskartBookingEntity;


/**
 * Repository interface for managing BuskartBookingEntity.
 * 
 * @author 
 * Kuntal
 */

public interface BuskartBookingJpaRepository extends JpaRepository<BuskartBookingEntity, Long> {
    /**
     * Find a booking by its unique booking ID.
     * @param bookingId The unique booking identifier.
     * @return The booking entity if found, else null.
     */
    @Cacheable(value = "bookingCache", key = "#bookingId")
    BuskartBookingEntity findByBookingId(String bookingId);
    
}
