package com.buskart.search.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.buskart.search.entity.BuskartBookingEntity;
import com.buskart.search.exception.SystemException;
import com.buskart.search.repository.elasticsearch.BuskartBookingElasticSearchRepository;
import com.buskart.search.repository.jpa.BuskartBookingJpaRepository;
import com.buskart.search.responseVo.BuskartBookingResponseVO;
import com.buskart.search.service.BuskartBookingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BuskartBookingServiceImpl implements BuskartBookingService  {
    
    @Autowired
    private BuskartBookingJpaRepository buskartBookingRepository ;


    @Autowired
    private BuskartBookingElasticSearchRepository buskartBookingElasticSearchRepository;


    @Override
    @Cacheable(value = "bookingCache", key = "#bookingId")
    public BuskartBookingResponseVO getBookingByBookingId(String bookingId) throws SystemException {
        try {
            
            BuskartBookingEntity buskartBookingEntity = buskartBookingElasticSearchRepository.findByBookingId(bookingId);
            if (buskartBookingEntity != null) {

                BuskartBookingResponseVO buskartBookingResponseVO= new BuskartBookingResponseVO();
                
                buskartBookingResponseVO.setAmount(buskartBookingEntity.getAmount());
                buskartBookingResponseVO.setBookingDate(buskartBookingEntity.getBookingDate());
                buskartBookingResponseVO.setBusType(buskartBookingEntity.getBusType());
                buskartBookingResponseVO.setCustomerName(buskartBookingEntity.getCustomerName());
                buskartBookingResponseVO.setDestination(buskartBookingEntity.getDestination());
                buskartBookingResponseVO.setSeatNumber(buskartBookingEntity.getSeatNumber());
                buskartBookingResponseVO.setSource(buskartBookingEntity.getSource());
                
               
                return buskartBookingResponseVO;
            }
        } catch (Exception e) {
            log.error("System error occurred while retrieving booking with bookingId: {}", bookingId, e);
             throw new SystemException("An error occurred while retrieving the booking. Please try again later.", e);
        }
        return null;
    }

  
}
