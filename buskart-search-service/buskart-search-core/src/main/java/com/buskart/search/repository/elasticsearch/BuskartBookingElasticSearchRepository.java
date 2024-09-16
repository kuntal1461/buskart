package com.buskart.search.repository.elasticsearch;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.buskart.search.entity.BuskartBookingEntity;


/**
 * Elastic search Repository interface for managing BuskartBookingEntity.
 * 
 * @author 
 * Kuntal
 */

public interface BuskartBookingElasticSearchRepository extends ElasticsearchRepository <BuskartBookingEntity,Long> {
    
    @Cacheable(value = "bookingCache", key = "#bookingId")
    BuskartBookingEntity findByBookingId(String bookingId);
}
