package com.buskart.search.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.buskart.search.entity.BuskartBookingEntity;


/**
 * Repository interface for managing BuskartBookingEntity.
 * 
 * @author 
 * Kuntal
 */
public interface BuskartBookingRepository extends ElasticsearchRepository<BuskartBookingEntity, Long> {
    
    /**
     * Find a booking by its unique booking ID.
     * @param bookingId The unique booking identifier.
     * @return The booking entity if found, else null.
     */
    @Cacheable(value = "bookingCache", key = "#bookingId")
    BuskartBookingEntity findByBookingId(String bookingId);
    
}
