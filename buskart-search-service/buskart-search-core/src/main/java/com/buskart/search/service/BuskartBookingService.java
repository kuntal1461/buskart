package com.buskart.search.service;

import org.springframework.stereotype.Service;

import com.buskart.search.exception.SystemException;
import com.buskart.search.responseVo.BuskartBookingResponseVO;

@Service
public interface BuskartBookingService {
    

    public BuskartBookingResponseVO getBookingByBookingId(String bookingId) throws SystemException;

}
